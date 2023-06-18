package com.example.database.repository;

import com.example.database.domain.ProfessorEntity;
import com.example.database.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Integer> {

    //1.a professor 테이블의 모든 정보를 반환한다.
    @Override
    @Query(
            value = "SELECT * FROM PROFESSOR",
            nativeQuery = true
    )
    List<ProfessorEntity> findAll();

    //1.a professor 테이블의 tuple 수를 반환한다.
    @Query(
            value = "SELECT COUNT(*) FROM PROFESSOR",
            nativeQuery=true
    )
    int cnt();
}
