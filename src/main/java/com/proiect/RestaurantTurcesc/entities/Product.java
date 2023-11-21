package com.proiect.RestaurantTurcesc.entities;

import com.proiect.RestaurantTurcesc.helpers.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String name;

    @Column(name = "price", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Double price;

    @Column(name = "description", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String description;

    @Column(name = "quantity", columnDefinition = "TEXT", updatable = true, nullable = false)
    private short quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Category category;
}
