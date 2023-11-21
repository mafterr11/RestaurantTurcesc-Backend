package com.proiect.RestaurantTurcesc.controller;

import com.proiect.RestaurantTurcesc.entities.Category;
import com.proiect.RestaurantTurcesc.helpers.MapEntities;
import com.proiect.RestaurantTurcesc.models.category.CategoryResponse;
import com.proiect.RestaurantTurcesc.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryResponse>> findAll(){
       return new ResponseEntity<>(this.categoryService.findAll().stream().map(c-> MapEntities.mapCategoryToCategoryResponse(c)).toList(), HttpStatus.OK);
    }
}
