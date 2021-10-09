package com.example.callcenterproject.mapper;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import com.example.callcenterproject.entity.Operator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperatorMapper {
    Operator requestDtoToEntity(OperatorRequestDto dto);
    OperatorResponseDto entityToResponseDto(Operator entity);
}
