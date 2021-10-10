package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.CustomerCallRequestDto;
import com.example.callcenterproject.dto.CustomerCallResponseDto;
import com.example.callcenterproject.service.inter.CustomerCallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/customer-call")
public class CustomerCallController {

    private final CustomerCallService customerCallService;

    public CustomerCallController(CustomerCallService customerCallService) {
        this.customerCallService = customerCallService;
    }

    @PostMapping
    public ResponseEntity<CustomerCallResponseDto> createCustomerCall(@RequestHeader("Authorization") String token,
                                                                      @RequestBody CustomerCallRequestDto requestDto) {
        log.info("Posting customer call");
        return new ResponseEntity<>(customerCallService.createCustomerCall(token.substring(7), requestDto), HttpStatus.CREATED);
    }
}
