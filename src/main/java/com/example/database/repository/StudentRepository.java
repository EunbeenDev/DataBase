package com.example.database.repository;

import com.example.database.domain.StudentEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    //1.a student 테이블의 모든 내용을 반환한다.
    @Override
    @Query(
            value = "SELECT * FROM STUDENT",
            nativeQuery = true
    )
    List<StudentEntity> findAll();

    //1.a student 테이블의 tuple 수를 반환한다.
    @Query(
            value = "SELECT COUNT(*) FROM STUDENT",
            nativeQuery=true
    )
    int cnt();


    //2.b 학생 정보를 모두 반환한다.
    @Query(
            value="SELECT * FROM STUDENT",
            nativeQuery = true
    )
    List<Object[]> getAllStudents();

    //2.b 웹페이지에서 클릭한 학생 이름을 파라미터 studentName으로 받아,
    // 해당 학생이 수강하는 Course 이름과 학점 및 시험 점수를 반환한다.
    @Query(
            value="SELECT S.SNAME, C.CNAME, C.CREDIT, E.EXAM\n" +
                    "FROM STUDENT S, COURSE C, ENROLL E\n" +
                    "WHERE S.SNAME= :studentName AND S.SNO=E.SNO AND C.CNO=E.CNO",
            nativeQuery = true
    )
    List<Object[]> getStudentByName(@Param("studentName") String studentName);


    //1.e 학생별로 수강한 교과목의 총학점과 시험점수의 평균을 반환한다.
    @Query(
            value="SELECT S.SNAME, SUM(C.CREDIT), AVG(E.EXAM)\n" +
                    "FROM ENROLL E, STUDENT S, COURSE C\n" +
                    "WHERE E.CNO=C.CNO AND E.SNO=S.SNO\n" +
                    "GROUP BY S.SNAME",
            nativeQuery = true
    )
    List<Object[]> totCour();

    //1.h 학과별, 학년별 총 학생 수를 반환한다.
    @Query(
            value="SELECT DEPT, YEAR, COUNT(SNO)\n" +
                    "FROM STUDENT\n" +
                    "GROUP BY DEPT,YEAR\n" +
                    "ORDER BY DEPT, YEAR",
            nativeQuery = true
    )
    List<Object[]> stuCnt();

}
