package com.example.database.repository;

import com.example.database.domain.AuthorEntity;
import com.example.database.domain.AuthorId;
import com.example.database.domain.BookEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, AuthorId> {

    //2.a 모든 작가들에 대한 정보를 반환한다.
    @Query(
            value="SELECT NAME FROM AUTHOR",
            nativeQuery = true
    )
    List<Object[]> getAllAuthors();


    //2.a 선택한 작가의 이름을 파라미터로 받아, 해당 작가가 작성한 도서의 제목, 해당 도서의 재고 수량을 반환한다.
    @Query(
            value="SELECT A.NAME,B.TITLE,SUM(S.NUM)\n" +
                    "FROM AUTHOR A, WRITTEN_BY W,STOCKS S, BOOK B\n" +
                    "WHERE A.NAME= :authorName AND A.NAME=W.NAME AND W.ISBN=S.ISBN AND B.ISBN=S.ISBN\n" +
                    "GROUP BY A.NAME,B.TITLE",
            nativeQuery = true
    )
    List<Object[]> getAuthorByName(@Param("authorName") String authorName);


    //2.d insert author
    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO AUTHOR(NAME,ADDRESS,URL) VALUES ( :name, :address, :url)",
            nativeQuery = true
    )
    BookEntity saveOne(
            @Param("name") String name,
            @Param("address") String address,
            @Param("url") String url
    );


    //2.f 작가별 도서의 총 개수, 최고, 최저, 평균 가격을 반환한다.
    @Query(
            value="SELECT W.NAME, COUNT(W.ISBN), MAX(B.PRICE), MIN(B.PRICE),ROUND(AVG(B.PRICE),2)\n" +
                    "FROM WRITTEN_BY W, BOOK B\n" +
                    "WHERE W.ISBN=B.ISBN\n" +
                    "GROUP BY W.NAME,W.ADDRESS",
            nativeQuery = true
    )
    List<Object[]> authInfo();


}
