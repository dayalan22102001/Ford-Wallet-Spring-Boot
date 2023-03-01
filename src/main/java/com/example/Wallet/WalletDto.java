package com.example.Wallet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class WalletDto {
    public WalletDto(Integer id, String name, Double balance, LocalDate dateofCreation) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        DateofCreation = dateofCreation;
    }


    @NotNull(message = "Id cant be null")
    @Id
    private Integer id;

    @NotBlank(message = "Name cant be blank")
    @Pattern(regexp = "[a-zA-Z]{3,20}", message = "Name should contain 3 - 20 character and no special characters allowed")
    private String name;
    private Double balance;
    private LocalDate DateofCreation;

    public LocalDate getDateofCreation() {
        return DateofCreation;
    }

    public void setDateofCreation(LocalDate dateofCreation) {
        DateofCreation = dateofCreation;
    }

    public WalletDto(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;

    }

    public WalletDto() {

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

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", DateofCreation=" + DateofCreation +
                '}';
    }
}
