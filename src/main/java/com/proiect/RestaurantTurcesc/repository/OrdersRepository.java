package com.proiect.RestaurantTurcesc.repository;

import com.proiect.RestaurantTurcesc.entities.Order;
import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderByUserId(Integer id);

}
