package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.service.inter.AdvertisementTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/advertisement-type")
public class AdvertisementTypeController {

    private final AdvertisementTypeService advertisementTypeService;

    public AdvertisementTypeController(AdvertisementTypeService advertisementTypeService) {
        this.advertisementTypeService = advertisementTypeService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementTypeResponseDto> createAdvertisementType(@RequestBody AdvertisementTypeRequestDto requestDto) {
        log.info("Advertisement type created successfully");
        return new ResponseEntity<>(advertisementTypeService.createAdvertisementType(requestDto), HttpStatus.CREATED);
    }
}
