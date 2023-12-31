package com.proiect.RestaurantTurcesc.service.product;

import com.proiect.RestaurantTurcesc.helpers.CategoryEnum;
import com.proiect.RestaurantTurcesc.models.product.ProductRequest;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;

import java.util.List;

public interface ProductsService {

    ProductResponse createProduct(ProductRequest productRequest);

    void deleteProduct(Integer id);

    void deleteAll();

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);

    List<ProductResponse> findByCategory(CategoryEnum category);

    ProductResponse updateProduct(Integer id, ProductRequest productRequest);
}
