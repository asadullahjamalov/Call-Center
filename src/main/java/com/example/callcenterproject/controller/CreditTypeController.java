package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.service.inter.CreditTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/credit-type")
public class CreditTypeController {
    private final CreditTypeService creditTypeService;

    public CreditTypeController(CreditTypeService creditTypeService) {
        this.creditTypeService = creditTypeService;
    }

    @PostMapping
    public ResponseEntity<CreditTypeResponseDto> createCreditType(@RequestBody CreditTypeRequestDto requestDto) {
        log.info("Credit type created successfully");
        return new ResponseEntity<>(creditTypeService.createCreditType(requestDto), HttpStatus.CREATED);
    }
}
