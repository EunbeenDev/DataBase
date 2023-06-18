package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="CONTAINS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ContainsId.class)
public class ContainsEntity {
    @Id
    @Column(name="BASKETID")
    private String basketId;

    @Id
    @Column(name="ISBN")
    private int isbn;

    @Column(name="NUM")
    private int num;
}
