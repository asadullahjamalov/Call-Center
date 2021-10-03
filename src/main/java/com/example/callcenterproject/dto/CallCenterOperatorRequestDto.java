package com.example.callcenterproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallCenterOperatorRequestDto {
    private String name;
    private String surname;
    private long phoneNumber;
    private String username;
    private String password;
}
