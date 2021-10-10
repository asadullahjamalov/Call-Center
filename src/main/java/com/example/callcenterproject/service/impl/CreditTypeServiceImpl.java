package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.entity.CreditType;
import com.example.callcenterproject.exception.CreditTypeNotFound;
import com.example.callcenterproject.mapper.CreditTypeMapper;
import com.example.callcenterproject.model.ExceptionResponse;
import com.example.callcenterproject.repository.CreditTypeRepo;
import com.example.callcenterproject.service.inter.CreditTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public CreditTypeResponseDto getCreditTypeById(long id) {
        CreditType creditType = creditTypeRepo.findById(id)
                .orElseThrow(() -> new CreditTypeNotFound(
                        new ExceptionResponse("Credit type not found", 404)));
        return creditTypeMapper.entityToResponseDto(creditType);
    }

    @Override
    public List<CreditTypeResponseDto> getAllCreditTypes() {
        List<CreditType> creditTypeList = creditTypeRepo.findAll();
        return creditTypeMapper.entityListToResponseDtoList(creditTypeList);
    }

    @Override
    public CreditTypeResponseDto updateCreditTypeById(CreditTypeRequestDto requestDto, long id) {
        CreditType creditType = creditTypeRepo.findById(id)
                .orElseThrow(() -> new CreditTypeNotFound(
                        new ExceptionResponse("Credit type not found", 404)));
        creditType.setCreditType(requestDto.getCreditType());
        return creditTypeMapper.entityToResponseDto(creditTypeRepo.save(creditType));
    }
}
