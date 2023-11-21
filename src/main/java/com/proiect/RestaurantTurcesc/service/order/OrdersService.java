package com.proiect.RestaurantTurcesc.service.order;

import com.proiect.RestaurantTurcesc.entities.Order;
import com.proiect.RestaurantTurcesc.models.order.OrderRequest;
import com.proiect.RestaurantTurcesc.models.order.OrderResponse;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;

import java.util.List;

public interface OrdersService {

    OrderResponse createOrder(OrderRequest orderRequest, UserResponse userResponse, ProductResponse productResponse);

    void deleteOrder(Integer id);

    void deleteAll();

    List<Order> findAll();

    OrderResponse findById(Integer id);

    OrderResponse updateOrder(Integer id, OrderRequest orderRequest);
}
