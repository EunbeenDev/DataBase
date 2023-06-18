package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PUBLISHER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublisherEntity {
    @Id
    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String address;
}
