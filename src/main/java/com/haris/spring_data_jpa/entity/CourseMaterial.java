package com.haris.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    @OneToOne(cascade = CascadeType.ALL,
    optional = false,
    fetch = FetchType.LAZY)
    private Course course;
}
