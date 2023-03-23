package com.example.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WalletDto,Integer> {

    WalletDto findByEmail(String email);
}
