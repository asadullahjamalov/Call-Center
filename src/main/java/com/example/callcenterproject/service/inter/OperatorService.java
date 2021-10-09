package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;

public interface OperatorService {
    OperatorResponseDto addAgent(OperatorRequestDto requestDto);
}
