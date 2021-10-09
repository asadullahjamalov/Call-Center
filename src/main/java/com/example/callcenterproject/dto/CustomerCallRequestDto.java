package com.example.callcenterproject.dto;


public class CustomerCallRequestDto {
    private String name;
    private String surname;
    private String address;
    private String note;
    private long creditTypeId;
    private long advertisementTypeId;

    public CustomerCallRequestDto() {
    }

    public CustomerCallRequestDto(String name, String surname, String address, String note,
                                  long creditTypeId, long advertisementTypeId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.note = note;
        this.creditTypeId = creditTypeId;
        this.advertisementTypeId = advertisementTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(long creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    public long getAdvertisementTypeId() {
        return advertisementTypeId;
    }

    public void setAdvertisementTypeId(long advertisementTypeId) {
        this.advertisementTypeId = advertisementTypeId;
    }
}
