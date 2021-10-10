package com.example.callcenterproject.service.inter;

import com.example.callcenterproject.dto.AdvertisementTypeRequestDto;
import com.example.callcenterproject.dto.AdvertisementTypeResponseDto;
import com.example.callcenterproject.dto.CreditTypeRequestDto;
import com.example.callcenterproject.dto.CreditTypeResponseDto;

import java.util.List;

public interface AdvertisementTypeService {
    AdvertisementTypeResponseDto createAdvertisementType(AdvertisementTypeRequestDto requestDto);

    AdvertisementTypeResponseDto getAdvertisementTypeById(long id);

    List<AdvertisementTypeResponseDto> getAllAdvertisementTypes();

    AdvertisementTypeResponseDto updateAdvertisementTypeById(AdvertisementTypeRequestDto requestDto, long id);
}
