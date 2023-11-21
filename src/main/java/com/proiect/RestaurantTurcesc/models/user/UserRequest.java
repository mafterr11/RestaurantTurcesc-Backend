package com.proiect.RestaurantTurcesc.models.user;

import com.proiect.RestaurantTurcesc.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

        private String firstName;
        private String lastName;
        private String email;
}
