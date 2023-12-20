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
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "category", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String category;
}
