package com.example.database.service;

import com.example.database.repository.ShoppingBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketService {
    @Autowired
    private ShoppingBasketRepository shoppingBasketRepository;
}
