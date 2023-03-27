package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String> {
    @Override
    @Query("SELECT e FROM #{#entityName} e WHERE e.deleted IS NULL")
    List<T> findAll();
}
