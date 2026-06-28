package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private Long pincode;

    @Enumerated(EnumType.STRING)
    @Column(name = "countrycode")
    private CountryCode countryCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

}