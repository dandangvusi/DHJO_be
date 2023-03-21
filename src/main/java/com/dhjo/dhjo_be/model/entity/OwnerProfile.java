package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owner_profiles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerProfile {
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
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", nullable = false, referencedColumnName = "id")
    private User owner;
}
