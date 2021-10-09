package com.example.callcenterproject.service.impl;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.mapper.AdvertisementTypeMapper;
import com.example.callcenterproject.repository.AdvertisementTypeRepo;
import com.example.callcenterproject.service.inter.AdvertisementTypeService;
import org.springframework.stereotype.Service;

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
}
