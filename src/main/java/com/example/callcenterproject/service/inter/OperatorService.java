package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface OperatorService {
    OperatorResponseDto addAgent(OperatorRequestDto requestDto);
//    UserDetails loadUserByUsername(String username);
}
