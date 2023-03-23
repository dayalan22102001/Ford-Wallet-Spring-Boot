package com.example.Wallet;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("auth")
@CrossOrigin(value = "http://localhost:4200/")
public class AuthController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("user")
    public String registerNewUser(@RequestBody WalletDto user){
        // check for email already exists throw exception
        this.userRepository.save(user);
        return "User registration success.";
    }

    @PostMapping("login")
    public WalletDto login(@RequestBody LoginDto loginDto, HttpServletResponse response) throws Exception {

        // Create a user service and log in method
        WalletDto user = this.userRepository.findByEmail(loginDto.getEmail());
        if(user == null) throw new Exception("User does not exists");
        if(! user.getPassword().equals(loginDto.getPassword()))
            throw new Exception("User password does not match");

        // JWT util
        String issuer = loginDto.getEmail();
        Date expiry= new Date(System.currentTimeMillis() + (1000 * 60 * 60 ));
        String jwt = Jwts.builder().setIssuer(issuer).setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256,"secretKey").compact();

        Cookie cookie = new Cookie("jwt",jwt);
        user.setJwt(jwt);
        response.addCookie(cookie);
        //return jwt;
                return user;
    }
    @PostMapping("logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("jwt","");
        response.addCookie(cookie);
        return "Logout Success !";
    }

    @GetMapping("user")
    public WalletDto getUser(@CookieValue("jwt") String jwt) throws Exception {
        if(jwt == null)
            throw new Exception("Unauthenticated !");
        // Jwt Util class
        Claims claim=null;
        String email=null;
        try{
            claim = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(jwt).getBody();
             email = claim.getIssuer();

        }
        catch (ExpiredJwtException e){
            throw new Exception("JWT got Expired please log in again.");

        }
        catch (SignatureException e){
            throw new Exception("JWT Signature Exception.");
        }
        catch (Exception e){
            throw  new Exception("Unauthenticated !");
        }

        return this.userRepository.findByEmail(email);

    }

    // API with bearer token of JWT

    @GetMapping("userinfo")
    public WalletDto getUserInfo(@RequestHeader("Authorization") String bearerToken ) throws Exception {
        String jwt = bearerToken.substring(7);
        String email = jwtUtil.validateJwtAndGetUserEmail(jwt);
        return this.userRepository.findByEmail(email);

    }
}
