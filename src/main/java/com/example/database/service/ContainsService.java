package com.example.database.service;

import com.example.database.repository.ContainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainsService {
    @Autowired
    private ContainsRepository containsRepository;
}
