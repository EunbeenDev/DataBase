package com.example.database.service;

import com.example.database.domain.StudentEntity;
import com.example.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }


    public int cnt() {
        return studentRepository.cnt();
    }

    public List<Object[]> stuCnt() {
        return studentRepository.stuCnt();
    }
    public List<Object[]> getAllStudents() { return studentRepository.getAllStudents(); }

    public List<Object[]> getStudentByName(String studentName) { return studentRepository.getStudentByName(studentName); }

    public List<Object[]> totCour() { return studentRepository.totCour(); }
}


