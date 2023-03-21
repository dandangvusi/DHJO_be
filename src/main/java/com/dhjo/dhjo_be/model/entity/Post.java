package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    @Column(name = "time_to_start_working", nullable = false)
    private LocalDateTime time_to_start_working;
    @Column(name = "work_time", nullable = false)
    private int work_time;
    @Column(name = "fee", nullable = false)
    private long fee;
    @Column(name = "confirm_by_owner", nullable = false)
    private boolean confirm_by_owner;
    @Column(name = "recur", nullable = false)
    private boolean recur;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "helper_id", referencedColumnName = "id")
    private User helper;
}
