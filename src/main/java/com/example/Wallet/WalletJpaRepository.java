package com.example.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletJpaRepository extends JpaRepository<WalletDto,Integer> {



}
