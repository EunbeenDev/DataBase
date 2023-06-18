package com.example.database.service;

import com.example.database.domain.PublishedByEntity;
import com.example.database.repository.PublishedByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishedByService {
    @Autowired
    private PublishedByRepository publishedByRepository;

    public PublishedByEntity save(PublishedByEntity publishedByEntity) {
        publishedByRepository.saveOne(
                publishedByEntity.getName(),
                publishedByEntity.getIsbn()
        );
        return publishedByEntity;
    }
}
