package com.proiect.RestaurantTurcesc.service.product;

import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.helpers.MapEntities;
import com.proiect.RestaurantTurcesc.models.product.ProductRequest;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = MapEntities.mapProductRequestToProduct(productRequest);
        Optional<Product> productAlreadyStored = productsRepository.findProductByName(productRequest.getName());
        if (productAlreadyStored.isPresent()) {
            return null;
        }

        Product newProduct = this.productsRepository.save(product);
        return MapEntities.mapProductToProductResponse(newProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productsRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.productsRepository.deleteAll();
    }

    @Override
    public List<ProductResponse> findAll() {
        return this.productsRepository.findAll()
                .stream()
                .map(p -> MapEntities.mapProductToProductResponse(p))
                .toList();
    }

    @Override
    public ProductResponse findById(Integer id) {
        Optional<Product> foundProduct = this.productsRepository.findById(id);
        if (foundProduct.isPresent()) {
            return MapEntities.mapProductToProductResponse(foundProduct.get());
        }
        return null;
    }

    @Override
    public ProductResponse updateProduct(Integer id, ProductRequest productRequest) {
        Optional<Product> foundProduct = this.productsRepository.findById(id);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setDescription(productRequest.getDescription());
            product.setQuantity(productRequest.getQuantity());
            return MapEntities.mapProductToProductResponse(product);
        }
        return null;
    }
}
