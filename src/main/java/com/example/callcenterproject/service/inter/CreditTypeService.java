package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;

import java.util.List;

public interface CreditTypeService {
    CreditTypeResponseDto createCreditType(CreditTypeRequestDto requestDto);

    CreditTypeResponseDto getCreditTypeById(long id);

    List<CreditTypeResponseDto> getAllCreditTypes();

    CreditTypeResponseDto updateCreditTypeById(CreditTypeRequestDto requestDto, long id);
}
