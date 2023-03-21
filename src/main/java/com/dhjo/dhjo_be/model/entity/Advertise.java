package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "advertises")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Advertise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "banner", nullable = false)
    private String banner;
    @Column(name = "expire_date", nullable = false)
    private LocalDate expire_date;
    @Column(name = "agency_name", nullable = false)
    private String agency_name;
    @Column(name = "detailed_info", nullable = false, length = 2000)
    private String detailed_info;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;
}
