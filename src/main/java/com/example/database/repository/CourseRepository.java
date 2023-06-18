package com.example.database.repository;

import com.example.database.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,CourseEntity> {

    //1.a course 테이블의 모든 정보를 반환한다.
    @Override
    @Query(
            value = "SELECT * FROM COURSE",
            nativeQuery = true
    )
    List<CourseEntity> findAll();

    //1.a course 테이블의 tuple 수를 반환한다.
    @Query(
            value = "SELECT COUNT(*) FROM COURSE",
            nativeQuery=true
    )
    int cnt();

    //1.g) 학과별로 개설된 강좌(Lecture)의 수를 반환한다.
    @Query(
            value="SELECT SUBSTR(CNO, 1,2) AS DEPT,COUNT(CNAME) AS CNT\n" +
                    "FROM COURSE\n" +
                    "GROUP BY SUBSTR(CNO, 1,2)",
            nativeQuery = true
    )
    List<Object[]> deptCour();
}
