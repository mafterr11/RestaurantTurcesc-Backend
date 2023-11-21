package com.proiect.RestaurantTurcesc.repository;

import com.proiect.RestaurantTurcesc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
