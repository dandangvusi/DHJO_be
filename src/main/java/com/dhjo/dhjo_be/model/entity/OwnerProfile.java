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
public class OwnerProfile extends IdentifyEntity {
    @Column(name = "name", length = 128, nullable = false)
    private String name;
    @Column(name = "phone_num", length = 12, nullable = false)
    private String phone_num;
    @Column(name = "identification_num", length = 12, nullable = false)
    private String identification_num;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", nullable = false, referencedColumnName = "id")
    private User owner;
}
