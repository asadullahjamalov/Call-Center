package com.example.callcenterproject.dto;

public class OperatorRequestDto {
    private String name;
    private String surname;
    private long phoneNumber;
    private String username;
    private String password;

    public OperatorRequestDto() {
    }

    public OperatorRequestDto(String name, String surname, long phoneNumber,
                              String username, String password) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
