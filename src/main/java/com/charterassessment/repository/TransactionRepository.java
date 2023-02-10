package com.charterassessment.repository;


import com.charterassessment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(" SELECT t FROM Transaction t WHERE t.customerId =:customerId and t.transactionDate >= DATEADD(MONTH , -3, CURRENT_DATE())")
    List<Transaction> findAllByCustomerId(String customerId);

}
