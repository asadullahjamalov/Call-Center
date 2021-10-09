package com.example.callcenterproject.mapper;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import com.example.callcenterproject.entity.Operator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperatorMapper {

    OperatorMapper INSTANCE = Mappers.getMapper( OperatorMapper.class );

    Operator requestDtoToEntity(OperatorRequestDto dto);

    OperatorResponseDto entityToResponseDto(Operator entity);
}