package com.ican.fttechcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tbl_comment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 500)
    private String comment;

    private LocalDateTime commentDate;



}
