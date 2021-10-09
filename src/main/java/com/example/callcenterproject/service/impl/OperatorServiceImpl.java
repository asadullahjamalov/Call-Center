package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import com.example.callcenterproject.entity.Operator;
import com.example.callcenterproject.exception.UsernameIsNotUnique;
import com.example.callcenterproject.mapper.OperatorMapper;
import com.example.callcenterproject.model.ExceptionResponse;
import com.example.callcenterproject.repository.OperatorRepo;
import com.example.callcenterproject.service.inter.OperatorService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepo operatorRepo;
    private final OperatorMapper operatorMapper;

    public OperatorServiceImpl(OperatorRepo operatorRepo, OperatorMapper operatorMapper) {
        this.operatorRepo = operatorRepo;
        this.operatorMapper = operatorMapper;
    }

    @Override
    public OperatorResponseDto addAgent(OperatorRequestDto requestDto) {
        Operator foundOperator = operatorRepo.getOperatorByUsername(requestDto.getUsername());
        if (foundOperator != null) {
            throw new UsernameIsNotUnique(new ExceptionResponse("Username is not unique", 400));
        }

        String encPassword = new BCryptPasswordEncoder().encode(requestDto.getPassword());
        requestDto.setPassword(encPassword);

        Operator operator = operatorRepo.save(operatorMapper.requestDtoToEntity(requestDto));
        return operatorMapper.entityToResponseDto(operator);
    }
}
