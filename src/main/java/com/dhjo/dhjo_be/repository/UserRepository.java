package com.dhjo.dhjo_be.repository;

import com.dhjo.dhjo_be.model.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>, JpaSpecificationExecutor<User> {
    @Query("SELECT u FROM User u WHERE u.id=?1 AND u.deleted IS NULL")
    User findUserById(String id);
    @Query("SELECT u FROM User u WHERE (u.username=?1 OR u.email=?2) AND u.deleted IS NULL")
    User findUserByUsernameOrEmail(String username, String email);
}
