package com.proiect.RestaurantTurcesc.models.order;

import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.entities.User;
import com.proiect.RestaurantTurcesc.helpers.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//Datele de la server la client
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private Integer id;
    private User user;
    private Product product;
    private Status status;
    private Double totalPrice;
    private LocalDateTime createdAt;
    private String error;
}


