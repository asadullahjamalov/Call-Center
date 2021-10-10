package com.example.callcenterproject.mapper;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.entity.AdvertisementType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertisementTypeMapper {

    AdvertisementTypeMapper INSTANCE = Mappers.getMapper(AdvertisementTypeMapper.class);

    AdvertisementType requestDtoToEntity(AdvertisementTypeRequestDto dto);

    AdvertisementTypeResponseDto entityToResponseDto(AdvertisementType entity);

    List<AdvertisementTypeResponseDto> entityListToResponseDtoList(List<AdvertisementType> entityList);
}
