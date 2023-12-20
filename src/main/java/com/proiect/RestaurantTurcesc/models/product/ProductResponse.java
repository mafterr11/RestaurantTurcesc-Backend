package com.proiect.RestaurantTurcesc.models.product;

import com.proiect.RestaurantTurcesc.helpers.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Datele de la server la client
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {

    private Integer id;
    private String name;
    private Double price;
    private String description;
    private short quantity;
    private CategoryEnum category;
    private String error;
}
