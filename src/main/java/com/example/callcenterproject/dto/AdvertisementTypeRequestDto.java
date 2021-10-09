package com.example.callcenterproject.dto;

public class AdvertisementTypeRequestDto {
    private String advertisementType;

    public AdvertisementTypeRequestDto() {
    }

    public AdvertisementTypeRequestDto(String advertisementType) {
        this.advertisementType = advertisementType;
    }

    public String getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(String advertisementType) {
        this.advertisementType = advertisementType;
    }
}
