package com.example.callcenterproject.dto;

public class AdvertisementTypeResponseDto {
    private long id;
    private String advertisementType;

    public AdvertisementTypeResponseDto() {
    }

    public AdvertisementTypeResponseDto(long id, String advertisementType) {
        this.id = id;
        this.advertisementType = advertisementType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(String advertisementType) {
        this.advertisementType = advertisementType;
    }
}
