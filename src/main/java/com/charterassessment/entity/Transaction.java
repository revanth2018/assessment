package com.charterassessment.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTION")
@Data
@NoArgsConstructor
public class Transaction extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "transaction_date")
    private Date transactionDate;


}
