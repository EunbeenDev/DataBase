package com.example.database.service;

import com.example.database.domain.EnrollEntity;
import com.example.database.repository.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;

    public List<EnrollEntity> findAll(){
        return enrollRepository.findAll();
    }

    public int cnt(){
        return enrollRepository.cnt();
    }

    public List<Object[]> avgExam() {
        return enrollRepository.avgExam();
    }

    public List<Object[]> gradeCnt(String cname) {
        return enrollRepository.gradeCnt(cname);
    }

    public List<Object[]> examMaxMin() {
        return  enrollRepository.examMaxMin();
    }

    public List<Object[]> examMin(String cno){ return enrollRepository.examMin(cno); }
    public List<Object[]> examMax(String cno){
        return enrollRepository.examMax(cno);
    }


    public List<Object[]> weiredGrade() { return enrollRepository.weiredGrade(); }

    public List<Object[]> correctGrade(String sno) { return enrollRepository.correctGrade(sno); }
}
