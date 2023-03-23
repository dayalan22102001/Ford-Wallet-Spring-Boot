package com.example.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface WalletJpaRepository extends JpaRepository<WalletDto,Integer> {

    //Creation of custom queries by method name using keyWords



//    List<WalletDto> findByName(String name);
//    List<WalletDto> findByEmail(String email);
//    List<WalletDto> findByNameContaining(String name);
//    List<WalletDto> findByBalanceBetweenOrderByNameDesc(Double minBalance,Double maxBalance);
//    List<WalletDto> findByBalanceBetweenOrderByNameAsc(Double minBalance,Double maxBalance);
//    List<WalletDto> findByBalanceBetweenOrderByBalanceDesc(Double minBalance,Double maxBalance);
//    // By writing JPQL Queries
//    @Query("SELECT wallet FROM WalletDto wallet")
//    List<WalletDto> getAllEmployees();
//
//    @Query("SELECT wallet FROM WalletDto wallet WHERE wallet.name LIKE :name")
//    List<WalletDto> getAllEmployeesHavingNameLike(String name);




}
