package com.example.database.service;
import com.example.database.domain.CourseEntity;
import com.example.database.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> findAll(){
        return courseRepository.findAll();
    }

    public int cnt(){
        return courseRepository.cnt();
    }

    public List<Object[]> DeptCour() {
        return courseRepository.deptCour();
    }
}
