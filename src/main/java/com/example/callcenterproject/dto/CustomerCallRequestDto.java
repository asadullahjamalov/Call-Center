package com.example.callcenterproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCallRequestDto {
    private String name;
    private String surname;
    private String address;
    private String note;
    private long creditTypeId;
    private long advertisementTypeId;
    private long callCenterOperatorId;
}
