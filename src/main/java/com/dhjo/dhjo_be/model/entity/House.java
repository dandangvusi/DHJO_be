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
public class House extends BaseEntity {
    @Column(name = "type", nullable = false, columnDefinition = "enum('HOUSE','APARTMENT')")
    private Enum.HOUSE_TYPE type;
    @Column(name = "floor_area", nullable = false)
    private int floor_area;
    @Column(name = "house_no", nullable = false, length = 10)
    private String house_no;
    @Column(name = "street", nullable = false, length = 255)
    private String street;
    @Column(name = "wards", nullable = false, length = 255)
    private String wards;
    @Column(name = "district", nullable = false, length = 255)
    private String district;
    @Column(name = "province", nullable = false, length = 255)
    private String province;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private User owner;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "coordinate_id", referencedColumnName = "id", nullable = true)
    private Coordinate coordinate;
}
