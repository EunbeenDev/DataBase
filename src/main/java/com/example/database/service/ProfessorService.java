package com.example.database.service;
import com.example.database.domain.ProfessorEntity;
import com.example.database.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    public List<ProfessorEntity> findAll(){
        return professorRepository.findAll();
    }

    public int cnt(){
        return professorRepository.cnt();
    }
}
