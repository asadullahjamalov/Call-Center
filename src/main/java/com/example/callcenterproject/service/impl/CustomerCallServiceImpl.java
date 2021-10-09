package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.CustomerCallRequestDto;
import com.example.callcenterproject.dto.CustomerCallResponseDto;
import com.example.callcenterproject.entity.CustomerCall;
import com.example.callcenterproject.mapper.CustomerCallMapper;
import com.example.callcenterproject.repository.CustomerCallRepo;
import com.example.callcenterproject.repository.OperatorRepo;
import com.example.callcenterproject.service.inter.CustomerCallService;
import com.example.callcenterproject.util.JwtTokenUtil;
import org.springframework.stereotype.Service;

@Service
public class CustomerCallServiceImpl implements CustomerCallService {

    private final CustomerCallRepo customerCallRepo;
    private final CustomerCallMapper customerCallMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final OperatorRepo operatorRepo;

    public CustomerCallServiceImpl(CustomerCallRepo customerCallRepo, CustomerCallMapper customerCallMapper,
                                   JwtTokenUtil jwtTokenUtil, OperatorRepo operatorRepo) {
        this.customerCallRepo = customerCallRepo;
        this.customerCallMapper = customerCallMapper;
        this.jwtTokenUtil = jwtTokenUtil;
        this.operatorRepo = operatorRepo;
    }

    @Override
    public CustomerCallResponseDto createCustomerCall(String token, CustomerCallRequestDto requestDto) {
        CustomerCall customerCall = customerCallMapper.requestDtoToEntity(requestDto);
        System.out.println("heeeereeee");
        System.out.println(jwtTokenUtil.getUsernameFromToken(token));
        customerCall.setOperator(operatorRepo.getOperatorByUsername(jwtTokenUtil.getUsernameFromToken(token)));
        System.out.println(jwtTokenUtil.getUsernameFromToken(token));
        return customerCallMapper.entityToResponseDto(customerCallRepo.save(customerCall));
    }
}
