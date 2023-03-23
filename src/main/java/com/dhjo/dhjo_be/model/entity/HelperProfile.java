package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "helper_profiles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelperProfile extends IdentifyEntity {
    @Column(name = "name", length = 128, nullable = false)
    private String name;
    @Column(name = "phone_num", length = 12, nullable = false)
    private String phone_num;
    @Column(name = "identification_num", length = 12, nullable = false)
    private String identification_num;
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.GENDER gender;
    @Column(name = "education", nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.EDUCATION education;
    @Column(name = "image", length = 255, nullable = false)
    private String image;
    @Column(name = "intro", length = 2000, nullable = false)
    private String intro;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "helper_id", nullable = false, referencedColumnName = "id")
    private User helper;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "helper_skill",
            joinColumns = @JoinColumn(name = "helper_profile_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    )
    private Set<Skill> skills;
}
