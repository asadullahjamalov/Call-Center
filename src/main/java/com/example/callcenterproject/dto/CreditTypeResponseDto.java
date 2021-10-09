package com.example.callcenterproject.dto;

public class CreditTypeResponseDto {
    private long id;
    private String creditType;

    public CreditTypeResponseDto() {
    }

    public CreditTypeResponseDto(long id, String creditType) {
        this.id = id;
        this.creditType = creditType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
}
