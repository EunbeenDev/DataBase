package com.example.database.repository;

import com.example.database.domain.StocksEntity;
import com.example.database.domain.StocksId;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StocksRepository extends JpaRepository<StocksEntity, StocksId> {

    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO STOCKS(ISBN,CODE,NUM) VALUES (:isbn, :code, :num)",
            nativeQuery = true
    )
    int saveOne(
            @Param("isbn") int isbn,
            @Param("code") String code,
            @Param("num") int num);


}
