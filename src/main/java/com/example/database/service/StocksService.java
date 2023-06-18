package com.example.database.service;

import com.example.database.domain.StocksEntity;
import com.example.database.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StocksService {
    @Autowired
    private StocksRepository stocksRepository;

    public StocksEntity save(StocksEntity stocksEntity) {
        stocksRepository.saveOne(
                stocksEntity.getIsbn(),
                stocksEntity.getCode(),
                stocksEntity.getNum()

        );
        return stocksEntity;
    }
}
