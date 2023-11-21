package com.proiect.RestaurantTurcesc.controller;

import com.proiect.RestaurantTurcesc.exceptions.ErrorMessage;
import com.proiect.RestaurantTurcesc.models.user.UserRequest;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;
import com.proiect.RestaurantTurcesc.service.order.OrdersService;
import com.proiect.RestaurantTurcesc.service.user.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;
    private final OrdersService ordersService;

    @Autowired
    public UsersController(UsersService usersService, OrdersService ordersService) {
        this.usersService = usersService;
        this.ordersService = ordersService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = usersService.createUser(userRequest);
        if (userResponse != null) {
            return new ResponseEntity<>(usersService.createUser(userRequest), HttpStatus.OK);
        }
        ErrorMessage errorMessage = new ErrorMessage("Email already exists");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        UserResponse foundUser = usersService.findById(id);
        if (foundUser != null) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll() {
        usersService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        UserResponse foundUser = usersService.findById(id);
        if (foundUser != null) {
            usersService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = usersService.updateUser(id, userRequest);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
