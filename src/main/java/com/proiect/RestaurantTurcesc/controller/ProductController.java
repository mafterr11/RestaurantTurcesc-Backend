package com.proiect.RestaurantTurcesc.controller;

import com.proiect.RestaurantTurcesc.exceptions.ErrorMessage;
import com.proiect.RestaurantTurcesc.helpers.CategoryEnum;
import com.proiect.RestaurantTurcesc.models.product.ProductRequest;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.service.product.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productsService.createProduct(productRequest);
        if (productResponse != null) {
            return new ResponseEntity<>(productsService.createProduct(productRequest), HttpStatus.OK);
        }
        ErrorMessage errorMessage = new ErrorMessage("Product already exists");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String category) {
        CategoryEnum cat = CategoryEnum.valueOf(category);
        return new ResponseEntity<>(productsService.findByCategory(cat), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        ProductResponse foundProduct = productsService.findById(id);
        if (foundProduct != null) {
            return new ResponseEntity<>(foundProduct, HttpStatus.OK);
        }
        ErrorMessage errorMessage = new ErrorMessage("Product not found");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll() {
        productsService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        ProductResponse foundProduct = productsService.findById(id);
        if (foundProduct != null) {
            productsService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        ErrorMessage errorMessage = new ErrorMessage("Product not found");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        ProductResponse updatedProduct = productsService.updateProduct(id, productRequest);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("Product not found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
