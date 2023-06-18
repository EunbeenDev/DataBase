package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="BASKET_OF")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BasketOfId.class)
public class BasketOfEntity {
    @Id
    @Column(name="EMAIL")
    private String email;
    @Id
    @Column(name="BASKETID")
    private String basketId;

}
