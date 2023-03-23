package com.example.Wallet;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name="WALLET_DTO")
public class WalletDto {
    public WalletDto(Integer id, String name, Double balance, LocalDate dateofCreation) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
    }


    //@NotNull(message = "Id cant be null")
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Name cant be blank")
    @Pattern(regexp = "[a-zA-Z]{3,20}", message = "Name should contain 3 - 20 character and no special characters allowed")
    private String name;
    private Double balance;
    private String email;
    private String password;
    @Transient
    private String jwt;

    public WalletDto(Integer id, String name, Double balance,
                     String email, String password, String jwt, String role) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.jwt = jwt;
        this.role = role;
    }

    private String role = "user";

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public WalletDto() {

    }
    public WalletDto(int i, String name, Double balance, String email, String password) {
    }

    public WalletDto(Integer id, String name, Double balance, String password) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.email = email;

    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
