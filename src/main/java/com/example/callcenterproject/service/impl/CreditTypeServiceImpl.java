package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.mapper.CreditTypeMapper;
import com.example.callcenterproject.repository.CreditTypeRepo;
import com.example.callcenterproject.service.inter.CreditTypeService;
import org.springframework.stereotype.Service;

@Service
public class CreditTypeServiceImpl implements CreditTypeService {

    private final CreditTypeRepo creditTypeRepo;
    private final CreditTypeMapper creditTypeMapper;

    public CreditTypeServiceImpl(CreditTypeRepo creditTypeRepo, CreditTypeMapper creditTypeMapper) {
        this.creditTypeRepo = creditTypeRepo;
        this.creditTypeMapper = creditTypeMapper;
    }

    @Override
    public CreditTypeResponseDto createCreditType(CreditTypeRequestDto requestDto) {
        return creditTypeMapper.entityToResponseDto(
                creditTypeRepo.save(creditTypeMapper.requestDtoToEntity(requestDto)));
    }
}
