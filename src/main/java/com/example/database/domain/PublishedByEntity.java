package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "PUBLISHED_BY")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PublishedById.class)
public class PublishedByEntity {
    @Id
    @Column(name="NAME")
    private String name;

    @Id
    @Column(name="ISBN")
    private int isbn;
}
