package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.model.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, String> {
}
