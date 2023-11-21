package com.proiect.RestaurantTurcesc.entities;

import com.proiect.RestaurantTurcesc.helpers.CategoryEnum;
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

//    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String category;
}
