package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.service.inter.CreditTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{creditTypeId}")
    public ResponseEntity<CreditTypeResponseDto> getCreditTypeById(@PathVariable long creditTypeId) {
        log.info("Get credit type by id successfully");
        return new ResponseEntity<>(creditTypeService.getCreditTypeById(creditTypeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CreditTypeResponseDto>> getAllCreditTypes() {
        log.info("Get all credit types successfully");
        return new ResponseEntity<>(creditTypeService.getAllCreditTypes(), HttpStatus.OK);
    }

    @PutMapping("/{creditTypeId}")
    public ResponseEntity<CreditTypeResponseDto> updateCreditTypeById(@RequestBody CreditTypeRequestDto requestDto,
                                                                      @PathVariable long creditTypeId) {
        log.info("Update credit type by id successfully");
        return new ResponseEntity<>(creditTypeService.updateCreditTypeById(requestDto, creditTypeId), HttpStatus.OK);
    }


}
