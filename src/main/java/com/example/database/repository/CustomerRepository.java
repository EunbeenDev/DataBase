package com.example.database.repository;

import com.example.database.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {

    //2.c 모든 고객 정보를 반환한다.
    @Query(
            value="SELECT * FROM CUSTOMER",
            nativeQuery = true
    )
    List<Object[]> getAllCustomers();

    //2.c 선택된 고객의 이름을 파라미터로 받아, 해당 고객이 주문한 도서와 해당 도서의 출판사, 저자의 정보를 반환한다.
    @Query(
            value="SELECT C.NAME, B.ISBN,B.TITLE,B.YEAR, B.PRICE, P.NAME 출판사명,P.ADDRESS 출판사주소,P.PHONE,P.URL 출판사URL, A.NAME 작가명, A.ADDRESS 작가주소, A.URL 작가URL\n" +
                    "FROM CUSTOMER C,BOOK B,PUBLISHER P, AUTHOR A, PUBLISHED_BY P_BY, CONTAINS CT,BASKET_OF BO, WRITTEN_BY WB\n" +
                    "WHERE C.NAME= :customerName AND C.EMAIL=BO.EMAIL AND BO.BASKETID=CT.BASKETID \n" +
                    "  AND CT.ISBN=B.ISBN AND B.ISBN=P_BY.ISBN AND P_BY.NAME=P.NAME AND B.ISBN=WB.ISBN AND WB.NAME=A.NAME",
            nativeQuery = true
    )
    List<Object[]> getCustomerByName(String customerName);
}
