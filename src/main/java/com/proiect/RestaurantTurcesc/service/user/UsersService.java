package com.proiect.RestaurantTurcesc.service.user;

import com.proiect.RestaurantTurcesc.entities.User;
import com.proiect.RestaurantTurcesc.models.user.UserRequest;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;

import java.util.List;

public interface UsersService {

    UserResponse createUser(UserRequest userRequest);

    void deleteAll();

    void deleteUser(Integer id);

    List<UserResponse> findAll();

    UserResponse findById(Integer id);

    UserResponse updateUser(Integer id, UserRequest userRequest);

    UserResponse updateOrders(User user);

}


