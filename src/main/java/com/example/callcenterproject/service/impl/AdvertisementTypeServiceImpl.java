package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.entity.AdvertisementType;
import com.example.callcenterproject.exception.AdvertisementTypeNotFound;
import com.example.callcenterproject.mapper.AdvertisementTypeMapper;
import com.example.callcenterproject.model.ExceptionResponse;
import com.example.callcenterproject.repository.AdvertisementTypeRepo;
import com.example.callcenterproject.service.inter.AdvertisementTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementTypeServiceImpl implements AdvertisementTypeService {

    private final AdvertisementTypeRepo advertisementTypeRepo;
    private final AdvertisementTypeMapper advertisementTypeMapper;

    public AdvertisementTypeServiceImpl(AdvertisementTypeRepo advertisementTypeRepo,
                                        AdvertisementTypeMapper advertisementTypeMapper) {
        this.advertisementTypeRepo = advertisementTypeRepo;
        this.advertisementTypeMapper = advertisementTypeMapper;
    }

    @Override
    public AdvertisementTypeResponseDto createAdvertisementType(AdvertisementTypeRequestDto requestDto) {
        return advertisementTypeMapper.entityToResponseDto(
                advertisementTypeRepo.save(advertisementTypeMapper.requestDtoToEntity(requestDto)));
    }

    @Override
    public AdvertisementTypeResponseDto getAdvertisementTypeById(long id) {
        AdvertisementType advertisementType = advertisementTypeRepo.findById(id)
                .orElseThrow(() -> new AdvertisementTypeNotFound(
                        new ExceptionResponse("Advertisement type not found", 404)));
        return advertisementTypeMapper.entityToResponseDto(advertisementType);
    }

    @Override
    public List<AdvertisementTypeResponseDto> getAllAdvertisementTypes() {
        List<AdvertisementType> advertisementTypeList = advertisementTypeRepo.findAll();
        return advertisementTypeMapper.entityListToResponseDtoList(advertisementTypeList);
    }

    @Override
    public AdvertisementTypeResponseDto updateAdvertisementTypeById(AdvertisementTypeRequestDto requestDto, long id) {
        AdvertisementType advertisementType = advertisementTypeRepo.findById(id)
                .orElseThrow(() -> new AdvertisementTypeNotFound(
                        new ExceptionResponse("Advertisement type not found", 404)));
        advertisementType.setAdvertisementType(requestDto.getAdvertisementType());
        return advertisementTypeMapper.entityToResponseDto(advertisementTypeRepo.save(advertisementType));
    }
}
