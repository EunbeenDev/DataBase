package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="BOOK")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @Column(name="ISBN")
    private int isbn;

    @Column(name="TITLE")
    private String title;

    @Column(name="YEAR")
    private int year;

    @Column(name="PRICE")
    private int price;

}
