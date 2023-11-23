package com.proiect.RestaurantTurcesc.helpers;

import com.proiect.RestaurantTurcesc.entities.Category;
import com.proiect.RestaurantTurcesc.entities.Order;
import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.entities.User;
import com.proiect.RestaurantTurcesc.models.category.CategoryResponse;
import com.proiect.RestaurantTurcesc.models.order.OrderRequest;
import com.proiect.RestaurantTurcesc.models.order.OrderResponse;
import com.proiect.RestaurantTurcesc.models.product.ProductRequest;
import com.proiect.RestaurantTurcesc.models.product.ProductResponse;
import com.proiect.RestaurantTurcesc.models.user.UserRequest;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;

public class MapEntities {
    public static User mapUserRequestToUser(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        return user;
    }

    public static UserResponse mapUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }

    public static User mapUserResponseToUser(UserResponse userResponse){
        User user = new User();
        user.setId(userResponse.getId());
        user.setEmail(userResponse.getEmail());
        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        return user;
    }


    public static OrderResponse mapOrderToOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setUser(order.getUser());
        orderResponse.setProduct(order.getProduct());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setCreatedAt(order.getCreatedAt());
        return orderResponse;
    }

    public static Order mapOrderResponseToOrder(OrderResponse orderResponse){
        Order order = new Order();
        order.setId(orderResponse.getId());
        order.setUser(orderResponse.getUser());
        order.setProduct(orderResponse.getProduct());
        order.setStatus(orderResponse.getStatus());
        order.setTotalPrice(orderResponse.getTotalPrice());
        order.setCreatedAt(orderResponse.getCreatedAt());
        return order;
    }

    public static Order mapOrderRequestToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus(orderRequest.getStatus());
        order.setTotalPrice(orderRequest.getTotalPrice());
        return order;
    }

    public static Product mapProductRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(productRequest.getCategory());
        return product;
    }

    public static ProductResponse mapProductToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setCategory(product.getCategory());
        return productResponse;
    }

    public static Product mapProductResponseToProduct(ProductResponse productResponse){
        Product product = new Product();
        product.setId(productResponse.getId());
        product.setName(productResponse.getName());
        product.setPrice(productResponse.getPrice());
        product.setDescription(productResponse.getDescription());
        product.setQuantity(productResponse.getQuantity());
        product.setCategory(productResponse.getCategory());
        return product;
    }

    public static CategoryResponse mapCategoryToCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setCategory(category.getCategory());
        return categoryResponse;
    }
}
