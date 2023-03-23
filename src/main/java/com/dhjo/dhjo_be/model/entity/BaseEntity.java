package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends IdentifyEntity {
    @Column(name = "created_at", nullable = false)
    protected Long created_at;
    @Column(name = "modified_at")
    protected Long modified_at;
    @Column(name = "deleted")
    protected Long deleted;
}
