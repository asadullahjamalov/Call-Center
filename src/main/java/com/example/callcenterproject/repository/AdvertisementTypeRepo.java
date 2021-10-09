package com.example.callcenterproject.repository;

import com.example.callcenterproject.entity.AdvertisementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementTypeRepo extends JpaRepository<AdvertisementType, Long> {
}
