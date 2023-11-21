package com.proiect.RestaurantTurcesc.service.order;

import com.proiect.RestaurantTurcesc.entities.Order;
import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.entities.User;
import com.proiect.RestaurantTurcesc.helpers.MapEntities;
import com.proiect.RestaurantTurcesc.models.order.OrderRequest;
import com.proiect.RestaurantTurcesc.models.order.OrderResponse;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;
import com.proiect.RestaurantTurcesc.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest, UserResponse userResponse, ProductResponse productResponse) {
        User user = MapEntities.mapUserResponseToUser(userResponse);
        Product product = MapEntities.mapProductResponseToProduct(productResponse);

        Order order = MapEntities.mapOrderRequestToOrder(orderRequest);
        Optional<Order> orderAlreadyStored = ordersRepository.findOrderByUserId(orderRequest.getUserId());
        if (orderAlreadyStored.isPresent()) {
            return null;
        }
        order.setUser(user);
        order.setProduct(product);
        Order newOrder = this.ordersRepository.save(order);
        return MapEntities.mapOrderToOrderResponse(newOrder);
    }

    @Override
    public void deleteOrder(Integer id) {
        this.ordersRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.ordersRepository.deleteAll();
    }

    @Override
    public List<Order> findAll() {
        return this.ordersRepository.findAll()
                .stream()
                .toList();
    }

    @Override
    public OrderResponse findById(Integer id) {
        Optional<Order> foundOrder = this.ordersRepository.findById(id);
        if (foundOrder.isPresent()) {
            return MapEntities.mapOrderToOrderResponse(foundOrder.get());
        }
        return null;
    }

    @Override
    public OrderResponse updateOrder(Integer id, OrderRequest orderRequest) {
        Optional<Order> foundOrder = this.ordersRepository.findById(id);
        if (foundOrder.isPresent()) {
            Order order = foundOrder.get();
            order.setStatus(orderRequest.getStatus());
            order.setTotalPrice(orderRequest.getTotalPrice());
            ordersRepository.save(order);
            return MapEntities.mapOrderToOrderResponse(order);
        }
        return null;
    }
}

