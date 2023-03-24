package com.dhjo.dhjo_be.model.entity;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "recurring_posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPost extends IdentifyEntity {
    @Column(name = "end_date", nullable = false)
    private LocalDate end_date;
    @Column(name = "period", nullable = false, columnDefinition = "enum('DAY','WEEK','MONTH')")
    private Enum.PERIOD period;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;
}
