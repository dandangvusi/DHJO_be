package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.model.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {
}
