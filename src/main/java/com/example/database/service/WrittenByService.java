package com.example.database.service;

import com.example.database.domain.WrittenByEntity;
import com.example.database.repository.WrittenByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WrittenByService {
    @Autowired
    private WrittenByRepository writtenByRepository;

    public WrittenByEntity save(WrittenByEntity writtenByEntity) {
        writtenByRepository.saveOne(
                writtenByEntity.getName(),
                writtenByEntity.getAddress(),
                writtenByEntity.getIsbn()
        );
        return writtenByEntity;
    }
}
