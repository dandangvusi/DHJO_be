package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends IdentifyEntity {
    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.ROLE role_name;
}
