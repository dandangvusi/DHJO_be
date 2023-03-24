package com.dhjo.dhjo_be.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    @Column(name = "time_to_start_working", nullable = false)
    private LocalDateTime time_to_start_working;
    @Column(name = "work_time", nullable = false)
    private int work_time;
    @Column(name = "fee", nullable = false)
    private Long fee;
    @Column(name = "confirm_by_owner", nullable = false)
    private boolean confirm_by_owner;
    @Column(name = "is_recur", nullable = false)
    private boolean is_recur;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private User owner;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "house_id", referencedColumnName = "id", nullable = false)
    private House house;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "helper_id", referencedColumnName = "id", nullable = true)
    private User helper;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable( name = "post_skill",
                joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
                )
    private Set<Skill> skills;
}
