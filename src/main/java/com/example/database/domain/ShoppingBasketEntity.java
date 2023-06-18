package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SHOPPING_BASKET")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingBasketEntity {
    @Id
    @Column(name="BASKETID")
    private String baksetId;
}
