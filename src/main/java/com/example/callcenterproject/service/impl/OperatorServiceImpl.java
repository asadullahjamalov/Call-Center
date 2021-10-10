package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import com.example.callcenterproject.entity.Operator;
import com.example.callcenterproject.exception.OperatorNotFound;
import com.example.callcenterproject.exception.UsernameIsNotUnique;
import com.example.callcenterproject.mapper.OperatorMapper;
import com.example.callcenterproject.model.ExceptionResponse;
import com.example.callcenterproject.repository.OperatorRepo;
import com.example.callcenterproject.service.inter.OperatorService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OperatorServiceImpl implements OperatorService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operator operator =  operatorRepo.getOperatorByUsername(username);
        if (operator!=null) {
            return new User(username, operator.getPassword(),
                    new ArrayList<>());
        } else {
            throw new OperatorNotFound(new ExceptionResponse("Operator not found with username: " + username, 404));
        }
    }
}
