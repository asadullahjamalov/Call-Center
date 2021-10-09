package com.example.callcenterproject.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "customer_requests")
public class CustomerCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String address;
    private String note;
    @ManyToOne
    private CreditType creditType;
    @ManyToOne
    private AdvertisementType advertisementType;
    @ManyToOne
    private Operator operator;


}
