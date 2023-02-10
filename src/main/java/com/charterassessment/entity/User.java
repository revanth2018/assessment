package com.charterassessment.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    @Id
    private Integer id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;


}
