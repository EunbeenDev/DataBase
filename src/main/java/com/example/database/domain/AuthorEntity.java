package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "AUTHOR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AuthorId.class)
public class AuthorEntity {
    @Id
    @Column(name="NAME")
    private String name;

    @Id
    @Column(name="ADDRESS")
    private String address;

    @Column(name="URL")
    private String url;

}
