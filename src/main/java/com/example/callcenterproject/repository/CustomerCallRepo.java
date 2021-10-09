package com.example.callcenterproject.repository;

import com.example.callcenterproject.entity.CustomerCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCallRepo extends JpaRepository<CustomerCall, Long> {
}
