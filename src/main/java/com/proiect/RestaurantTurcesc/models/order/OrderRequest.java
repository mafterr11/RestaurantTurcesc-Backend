package com.proiect.RestaurantTurcesc.models.order;

import com.proiect.RestaurantTurcesc.helpers.Status;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

        private Integer userId;
        private Integer productId;
        private Status status;
        private Double totalPrice;
}


