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
public class CustomerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String address;
    private String note;
    @OneToOne
    private CreditType creditType;
    @OneToOne
    private AdvertisementType advertisementType;
    @ManyToOne
    private CallCenterOperator callCenterOperator;


}
