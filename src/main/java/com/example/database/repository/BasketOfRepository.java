package com.example.database.repository;

import com.example.database.domain.BasketOfEntity;
import com.example.database.domain.BasketOfId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketOfRepository extends JpaRepository<BasketOfEntity, BasketOfId> {
}
