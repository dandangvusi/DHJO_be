package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coordinates")
public class Coordinate extends IdentifyEntity {
    @Column(name = "longitude", precision = 10, scale = 7, nullable = false)
    private BigDecimal longitude;
    @Column(name = "latitude", precision = 9, scale = 7, nullable = false)
    private BigDecimal latitude;
}
