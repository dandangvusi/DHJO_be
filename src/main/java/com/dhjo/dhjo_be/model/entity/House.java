package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "houses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type", nullable = false)
    private Enum.HOUSE_TYPE type;
    @Column(name = "floor_area", nullable = false)
    private int floor_area;
    @Column(name = "house_no", nullable = false, length = 10)
    private String house_no;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "wards", nullable = false)
    private String wards;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "province", nullable = false)
    private String province;
    @Column(name = "coordinate", nullable = false)
    private Point coordinate;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
}
