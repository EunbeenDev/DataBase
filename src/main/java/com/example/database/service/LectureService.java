package com.example.database.service;

import com.example.database.domain.LectureEntity;
import com.example.database.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;
    public List<LectureEntity> findAll(){
        return lectureRepository.findAll();
    }

    public int cnt(){
        return lectureRepository.cnt();
    }

}
