package com.proiect.RestaurantTurcesc.models.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Datele de la server la client
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {

    private Integer id;
    private String category;
}
