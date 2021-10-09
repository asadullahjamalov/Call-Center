package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;

public interface CreditTypeService {
    CreditTypeResponseDto createCreditType(CreditTypeRequestDto requestDto);
}
