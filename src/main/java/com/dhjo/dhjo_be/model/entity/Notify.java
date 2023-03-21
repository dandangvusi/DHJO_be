package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notifies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Notify {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    @Column(name = "is_read", nullable = false)
    private boolean is_read;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private User receiver;
}
