package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.model.entity.HelperAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelperAddressRepository extends JpaRepository<HelperAddress, String> {
}
