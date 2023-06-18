package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CUSTOMER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column(name="EMAIL")
    private String email;

    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="PHONE")
    private String phone;
}
