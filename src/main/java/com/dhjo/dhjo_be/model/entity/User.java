package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(name = "username", length = 64, nullable = false)
    private String username;
    @Column(name = "email", length = 128, nullable = false)
    private String email;
    @Column(name = "password", length = 128, nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable( name = "user_role",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
                )
    private Set<Role> roles;
}
