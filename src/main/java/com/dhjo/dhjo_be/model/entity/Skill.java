package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Skill extends IdentifyEntity {
    @Column(name = "skill_name", nullable = false, columnDefinition = "enum('ENGLISH','COOKING','LAUNDRY')")
    private Enum.SKILL skill_name;
}
