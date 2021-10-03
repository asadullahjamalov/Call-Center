package com.example.callcenterproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "operators")
public class CallCenterOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private long phoneNumber;
    private String username;
    private String password;
    @OneToMany
    private List<CustomerRequest> customerRequestList;

}
