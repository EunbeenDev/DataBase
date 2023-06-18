package com.example.database.repository;

import com.example.database.domain.BookEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    //@Overide
    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO BOOK(ISBN,TITLE,YEAR,PRICE) VALUES ( :isbn, :title, :year, :price)",
            nativeQuery = true
    )
    BookEntity saveOne(
            @Param("isbn") int isbn,
            @Param("title") String title,
            @Param("year") int year,
            @Param("price") int price
    );

    //2.e 전체 도서의 평균 가격을 반환한다.
    @Query(
            value="SELECT ROUND(AVG(PRICE),2)\n" +
                    "FROM BOOK",
            nativeQuery = true
    )
    List<Object[]> totBookPrice();

    //2.e 전체 도서의 년도별 평균 가격을 반환한다.
    @Query(
            value="SELECT YEAR,ROUND(AVG(PRICE),2)\n" +
                    "FROM BOOK\n" +
                    "GROUP BY YEAR\n"+
                    "ORDER BY YEAR",
            nativeQuery = true
    )
    List<Object[]> yearBookPrice();


    //2.g 재고가 특정 부수 이상 넘어가는 도서를 검색하고, 가격 할인을 적용하여 book table을 update한다.
    @Modifying
    @Query(
            value = "UPDATE BOOK\n" +
                    "SET PRICE = PRICE * (1 - (:saleRatio / 100))\n" +
                    "WHERE ISBN IN (\n" +
                    "    SELECT B.ISBN\n" +
                    "    FROM BOOK B, (SELECT ISBN, SUM(NUM) NUM FROM STOCKS GROUP BY ISBN) S\n" +
                    "    WHERE B.ISBN = S.ISBN AND S.NUM >= :quantity\n" +
                    ")",
            nativeQuery = true
    )
    void applySale(@Param("quantity") int quantity, @Param("saleRatio") float saleRatio);

    //2.g applySale에서 update를 적용한 도서들의 수정된 정보를 반환한다.
    @Query(
            value = "SELECT B.ISBN, B.TITLE, B.PRICE, B.YEAR, S.NUM\n" +
                    "FROM BOOK B, (SELECT ISBN, SUM(NUM) NUM FROM STOCKS GROUP BY ISBN) S\n" +
                    "WHERE B.ISBN = S.ISBN AND S.NUM >= :quantity",
            nativeQuery = true
    )
    List<Object[]> getAppliedBooks(@Param("quantity") int quantity);
}

