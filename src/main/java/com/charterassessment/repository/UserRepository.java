package com.charterassessment.repository;

import com.charterassessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByCustomerId(String customerID);
}
