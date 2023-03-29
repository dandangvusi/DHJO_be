package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.constant.Enum;
import com.dhjo.dhjo_be.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("SELECT r FROM Role r WHERE r.role_name=?1")
    Role findByRole_name(Enum.ROLE role);
}
