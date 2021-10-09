package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;

public interface AdvertisementTypeService {
    AdvertisementTypeResponseDto createAdvertisementType(AdvertisementTypeRequestDto requestDto);
}
