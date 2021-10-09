package com.example.callcenterproject.repository;

import com.example.callcenterproject.entity.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepo extends JpaRepository<CreditType, Long> {
}
