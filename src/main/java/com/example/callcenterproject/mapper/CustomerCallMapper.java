package com.example.callcenterproject.mapper;

import com.example.callcenterproject.dto.CustomerCallRequestDto;
import com.example.callcenterproject.dto.CustomerCallResponseDto;
import com.example.callcenterproject.entity.CustomerCall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerCallMapper {

    CustomerCallMapper INSTANCE = Mappers.getMapper(CustomerCallMapper.class);

    @Mappings({
            @Mapping(target = "advertisementType.id", source = "dto.advertisementTypeId"),
            @Mapping(target = "creditType.id", source = "dto.creditTypeId")
    })
    CustomerCall requestDtoToEntity(CustomerCallRequestDto dto);

    @Mappings({
            @Mapping(target = "advertisementTypeId", source = "advertisementType.id"),
            @Mapping(target = "creditTypeId", source = "creditType.id"),
            @Mapping(target = "operatorId", source = "operator.id")
    })
    CustomerCallResponseDto entityToResponseDto(CustomerCall entity);
}
