package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="WAREHOUSE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class WarehouseEntity {
    @Id
    @Column(name="CODE")
    private String code;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="PHONE")
    private String phone;


}
