package com.proiect.RestaurantTurcesc.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "category", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String category;
}
