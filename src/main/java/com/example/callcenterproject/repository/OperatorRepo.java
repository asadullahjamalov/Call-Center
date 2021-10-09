package com.example.callcenterproject.repository;

import com.example.callcenterproject.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperatorRepo extends JpaRepository<Operator, Long> {
    @Query(value = "select o from Operator o where o.username=:username")
    Operator getOperatorByUsername(String username);
}
