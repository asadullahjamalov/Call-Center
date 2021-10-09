package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.CustomerCallRequestDto;
import com.example.callcenterproject.dto.CustomerCallResponseDto;

public interface CustomerCallService {
    CustomerCallResponseDto createCustomerCall(String token, CustomerCallRequestDto requestDto);
}
