package com.example.callcenterproject.dto;

public class CreditTypeRequestDto {
    private String creditType;

    public CreditTypeRequestDto() {
    }

    public CreditTypeRequestDto(String creditType) {
        this.creditType = creditType;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
}
