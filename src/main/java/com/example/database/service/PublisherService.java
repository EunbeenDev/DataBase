package com.example.database.service;

import com.example.database.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Object[]> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }

    public List<Object[]> getPublisherByName(String publisherName) {
        return publisherRepository.getPublisherByName(publisherName);
    }
}
