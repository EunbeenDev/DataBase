package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="STOCKS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StocksId.class)
public class StocksEntity {
    @Id
    @Column(name="ISBN")
    private int isbn;

    @Id
    @Column(name="CODE")
    private String code;

    @Column(name="NUM")
    private int num;


}
