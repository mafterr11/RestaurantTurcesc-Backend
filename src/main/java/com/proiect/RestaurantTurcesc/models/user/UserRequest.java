package com.proiect.RestaurantTurcesc.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//Datele de la client la server
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

        private String firstName;
        private String lastName;
        private String email;
        private String password;
}
