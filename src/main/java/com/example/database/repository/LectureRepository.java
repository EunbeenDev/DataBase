package com.example.database.repository;

import com.example.database.domain.LectureEntity;
import com.example.database.domain.LectureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, LectureId> {

    //1.a lecture 테이블의 모든 정보를 반환한다.
    @Override
    @Query(
            value = "SELECT * FROM LECTURE",
            nativeQuery = true
    )
    List<LectureEntity> findAll();

    //1.a lecture 테이블의 tuple 수를 반환한다.
    @Query(
            value = "SELECT COUNT(*) FROM LECTURE",
            nativeQuery=true
    )
    int cnt();


}
