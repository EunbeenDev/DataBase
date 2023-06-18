package com.example.database.repository;

import com.example.database.domain.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity,String> {

    //2.b 모든 출판사의 정보를 반환한다.
    @Query(
            value="SELECT * FROM PUBLISHER",
            nativeQuery = true
    )
    List<Object[]> getAllPublishers();

    //2.b 선택된 출판사 이름을 파라미터로 받아, 해당 출판사에서 출판된 도서의 제목과 가격, 재고량을 반환한다.
    //재고량이 없는 경우, 해당 도서의 재고량은 0이다.
    @Query(
            value="SELECT P.NAME, B.TITLE, B.PRICE,SUM(S.NUM)\n" +
                    "FROM PUBLISHER P, BOOK B, PUBLISHED_BY P_BY, STOCKS S\n" +
                    "WHERE B.ISBN = P_BY.ISBN\n" +
                    "  AND B.ISBN = S.ISBN\n" +
                    "  AND P.NAME = :publisherName\n" +
                    "  AND P.NAME=P_BY.NAME\n" +
                    "GROUP BY P.NAME,B.TITLE, B.PRICE",
            nativeQuery = true
    )
    List<Object[]> getPublisherByName(@Param("publisherName") String publisherName);
}
