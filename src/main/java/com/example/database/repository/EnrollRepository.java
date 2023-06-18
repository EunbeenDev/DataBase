package com.example.database.repository;

import com.example.database.domain.EnrollEntity;
import com.example.database.domain.EnrollId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, EnrollId> {

    //1.a enroll 테이블의 전체 정보를 반환한다.
    @Override
    @Query(
            value = "SELECT * FROM ENROLL",
            nativeQuery = true
    )
    List<EnrollEntity> findAll();

    //1.a enroll 테이블의 tuple 수를 반환한다.
    @Query(
            value = "SELECT COUNT(*) FROM ENROLL",
            nativeQuery=true
    )
    int cnt();


    //1.c 성적 정보가 잘못되어 있는 학생의 정보를 반환한다.
    @Query(
            value="SELECT * FROM ENROLL\n" +
                    "MINUS\n" +
                    "SELECT * \n" +
                    "FROM ENROLL\n" +
                    "WHERE ((EXAM >= 90) AND GRADE='A')\n" +
                    "    OR ((EXAM BETWEEN 80 AND 89) AND GRADE='B')\n" +
                    "    OR ((EXAM BETWEEN 70 AND 79) AND GRADE='C')\n" +
                    "    OR ((EXAM BETWEEN 60 AND 69) AND GRADE='D')\n" +
                    "    OR ((EXAM < 60) AND GRADE='F')",
            nativeQuery = true
    )
    List<Object[]> weiredGrade();

    //1.c 성적 정보가 잘못되어 있는 학생의 정보를 제대로된 grade로 update한다.
    @Modifying
    @Query(
            value = "UPDATE ENROLL \n" +
                    "SET GRADE = CASE\n" +
                    "    WHEN EXAM >=90 THEN 'A'\n" +
                    "    WHEN EXAM BETWEEN 80 AND 89 THEN 'B'\n" +
                    "    WHEN EXAM BETWEEN 70 AND 79 THEN 'C'\n" +
                    "    WHEN EXAM BETWEEN 60 AND 69 THEN 'D'\n" +
                    "    WHEN EXAM < 60 THEN 'F'\n" +
                    "    END\n" +
                    "WHERE SNO = :studentNumber",
            nativeQuery = true
    )
    List<Object[]> correctGrade(@Param("studentNumber") String studentNumber);



    //1.d 과목별로 최고 점수와, 최저 점수를 반환한다.
    @Query(
            value="SELECT C.CNO, C.CNAME, MIN(E.EXAM),MAX(E.EXAM) FROM COURSE C, ENROLL E WHERE C.CNO=E.CNO GROUP BY C.CNO,C.CNAME",
            nativeQuery = true
    )
    List<Object[]> examMaxMin();

    //1.d 과목별 최저 점수와 같은 과목, 같은 점수인 학생에 대한 정보를 반환한다.
    @Query(
            value = "SELECT E.SNO, S.SNAME,S.YEAR,S.DEPT, P.PNAME\n" +
                    "FROM(SELECT CNO,MIN(EXAM) MIN FROM ENROLL GROUP BY CNO) M,ENROLL E,STUDENT S,COURSE C, PROFESSOR P\n" +
                    "WHERE M.CNO= :cno AND M.CNO=E.CNO AND M.CNO=C.CNO AND S.SNO=E.SNO AND P.PNO=S.PNO AND E.EXAM=M.MIN\n" +
                    "ORDER BY C.CNO, E.SNO",
            nativeQuery = true
    )
    List<Object[]> examMin(@Param("cno") String cno);

    //1.d 과목별 최고 점수와 같은 과목, 같은 점수인 학생에 대한 정보를 반환
    @Query(
            value = "SELECT E.SNO, S.SNAME,S.YEAR,S.DEPT, P.PNAME\n" +
                    "FROM(SELECT CNO,MAX(EXAM) MAX FROM ENROLL GROUP BY CNO) M,ENROLL E,STUDENT S,COURSE C, PROFESSOR P\n" +
                    "WHERE M.CNO= :cno AND M.CNO=E.CNO AND M.CNO=C.CNO AND S.SNO=E.SNO AND P.PNO=S.PNO AND E.EXAM=M.MAX\n" +
                    "ORDER BY C.CNO, E.SNO",
            nativeQuery = true
    )
    List<Object[]> examMax(@Param("cno") String cno);



    //1.f 과목별로 전체 평균 점수를 반환한다.
    @Query(
            value="SELECT C.CNAME,ROUND(AVG(E.EXAM),2)\n" +
                    "FROM COURSE C, ENROLL E\n" +
                    "WHERE C.CNO=E.CNO\n" +
                    "GROUP BY C.CNAME, E.CNO",
            nativeQuery = true
    )
    List<Object[]> avgExam();

    //1.f 과목별 학점별 학생 수를 반환한다.
    @Query(
            value = "SELECT C.CNAME,E.GRADE, COUNT(E.SNO)\n" +
                    "FROM COURSE C, ENROLL E\n" +
                    "WHERE C.CNO = E.CNO AND C.CNAME = :cname\n" +
                    "GROUP BY C.CNAME,E.GRADE\n" +
                    "ORDER BY E.GRADE",
            nativeQuery = true
    )
    List<Object[]> gradeCnt(@Param("cname") String cname);


}
