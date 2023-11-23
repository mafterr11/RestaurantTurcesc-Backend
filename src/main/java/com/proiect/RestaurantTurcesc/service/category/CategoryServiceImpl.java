package com.proiect.RestaurantTurcesc.service.category;

import com.proiect.RestaurantTurcesc.entities.Category;
import com.proiect.RestaurantTurcesc.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
      return  this.categoryRepository.findAll();
    }
}
