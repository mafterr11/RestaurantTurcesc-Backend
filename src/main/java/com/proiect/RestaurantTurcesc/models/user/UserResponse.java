package com.proiect.RestaurantTurcesc.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Datele de la server la client
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String error;
}
