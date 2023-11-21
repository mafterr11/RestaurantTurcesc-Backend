package com.proiect.RestaurantTurcesc.models.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {

        private String name;
        private Double price;
        private String description;
        private short quantity;
}
