package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "helper_profiles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelperProfile {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 255, nullable = true)
    private String name;
    @Column(name = "phone_num", length = 12, nullable = true)
    private String phone_num;
    @Column(name = "identification_num", length = 12, nullable = true)
    private String identification_num;
    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;
    @Column(name = "gender", nullable = true)
    @Enumerated(EnumType.STRING)
    private Enum.GENDER gender;
    @Column(name = "education", nullable = true)
    @Enumerated(EnumType.STRING)
    private Enum.EDUCATION education;
    @Column(name = "image", length = 255, nullable = true)
    private String image;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "helper_id", nullable = false, referencedColumnName = "id")
    private User helper;
}
