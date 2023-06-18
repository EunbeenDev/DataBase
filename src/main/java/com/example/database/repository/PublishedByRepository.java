package com.example.database.repository;

import com.example.database.domain.PublishedByEntity;
import com.example.database.domain.PublishedById;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PublishedByRepository extends JpaRepository<PublishedByEntity, PublishedById> {
    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO PUBLISHED_BY(NAME,ISBN) VALUES(:name, :isbn)",
            nativeQuery = true
    )
    int saveOne(
            @Param("name") String name,
            @Param("isbn") int isbn);
}
