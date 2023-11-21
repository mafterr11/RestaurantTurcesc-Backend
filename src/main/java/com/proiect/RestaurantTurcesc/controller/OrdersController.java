package com.proiect.RestaurantTurcesc.controller;

import com.proiect.RestaurantTurcesc.entities.Order;
import com.proiect.RestaurantTurcesc.exceptions.ErrorMessage;
import com.proiect.RestaurantTurcesc.models.order.OrderRequest;
import com.proiect.RestaurantTurcesc.models.order.OrderResponse;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;
import com.proiect.RestaurantTurcesc.service.order.OrdersService;
import com.proiect.RestaurantTurcesc.service.product.ProductsService;
import com.proiect.RestaurantTurcesc.service.user.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrdersService ordersService;
    private final UsersService usersService;
    private final ProductsService productsService;

    @Autowired
    public OrdersController(OrdersService ordersService, UsersService usersService, ProductsService productsService) {
        this.ordersService = ordersService;
        this.usersService = usersService;
        this.productsService = productsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        UserResponse userResponse = usersService.findById(orderRequest.getUserId());
        ProductResponse productResponse = productsService.findById(orderRequest.getProductId());
        if (userResponse == null || productResponse == null) {
            ErrorMessage errorMessage = new ErrorMessage("User/Product does not exist");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
       OrderResponse orderResponse = ordersService.createOrder(orderRequest, userResponse, productResponse);
       if(orderResponse != null){
           return new ResponseEntity<>(ordersService.createOrder(orderRequest, userResponse, productResponse), HttpStatus.OK);
       }
        ErrorMessage errorMessage = new ErrorMessage("Product already exists");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        OrderResponse foundOrder = ordersService.findById(id);
        if(foundOrder != null){
            return new ResponseEntity<>(foundOrder, HttpStatus.OK);
        }else{
            ErrorMessage errorMessage = new ErrorMessage("Order not found");
            return new ResponseEntity<>(errorMessage ,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        ordersService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        OrderResponse foundOrder = ordersService.findById(id);
        if(foundOrder != null){
            ordersService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            ErrorMessage errorMessage = new ErrorMessage("Order not found");
            return new ResponseEntity<>(errorMessage ,HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer id, @RequestBody OrderRequest orderRequest){
        OrderResponse updatedOrder = ordersService.updateOrder(id, orderRequest);
        if(updatedOrder != null){
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        }else {
            ErrorMessage errorMessage = new ErrorMessage("Order not found");
            return new ResponseEntity<>(errorMessage ,HttpStatus.NOT_FOUND);
        }
    }
}
