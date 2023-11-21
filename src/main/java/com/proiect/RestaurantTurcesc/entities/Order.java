package com.proiect.RestaurantTurcesc.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proiect.RestaurantTurcesc.helpers.Status;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "total_price", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Status status;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "TEXT", updatable = true, nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "product_id_fk")
    )

    private Product product;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk")
    )

    private User user;
}
