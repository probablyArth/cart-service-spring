package org.sst.cart.dtos.services;

import lombok.Getter;
import lombok.Setter;
import org.sst.cart.dtos.ProductDto;

import java.time.LocalDate;

@Getter @Setter
class ProductResponse {
    Long productId;
    Long quantity;
}
@Getter @Setter
public class CreateOrUpdateProductsResponse {
    Long id;
    Long userId;
    LocalDate date;
    ProductResponse[] products;
}