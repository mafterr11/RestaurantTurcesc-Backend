package com.proiect.RestaurantTurcesc.repository;

import com.proiect.RestaurantTurcesc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductByName(String name);
}
