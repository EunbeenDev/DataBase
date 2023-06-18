package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "WRITTEN_BY")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WrittenById.class)
public class WrittenByEntity {

    @Id
    @Column(name = "NAME")
    private String name;

    @Id
    @Column(name = "ADDRESS")
    private String address;

    @Id
    @Column(name = "ISBN")
    private String isbn;

}
