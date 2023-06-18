package com.example.database.repository;

import com.example.database.domain.WrittenByEntity;
import com.example.database.domain.WrittenById;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WrittenByRepository extends JpaRepository<WrittenByEntity, WrittenById> {
    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO WRITTEN_BY(NAME,ADDRESS,ISBN) VALUES ( :name, :address, :isbn)",
            nativeQuery = true
    )
    int saveOne(
            @Param("name") String name,
            @Param("address") String address,
            @Param("isbn") String isbn
    );
}
