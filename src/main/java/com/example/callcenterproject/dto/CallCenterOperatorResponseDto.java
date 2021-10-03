package com.example.callcenterproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallCenterOperatorResponseDto {
    private long id;
    private String name;
    private String surname;
    private long phoneNumber;
    private String username;
}
