package com.example.callcenterproject.mapper;

import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;
import com.example.callcenterproject.entity.CreditType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditTypeMapper {

    CreditTypeMapper INSTANCE = Mappers.getMapper(CreditTypeMapper.class);

    CreditType requestDtoToEntity(CreditTypeRequestDto dto);

    CreditTypeResponseDto entityToResponseDto(CreditType entity);

    List<CreditTypeResponseDto> entityListToResponseDtoList(List<CreditType> entityList);
}
