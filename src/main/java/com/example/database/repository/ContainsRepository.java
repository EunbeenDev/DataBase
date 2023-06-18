package com.example.database.repository;

import com.example.database.domain.ContainsEntity;
import com.example.database.domain.ContainsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainsRepository extends JpaRepository<ContainsEntity, ContainsId> {
}
