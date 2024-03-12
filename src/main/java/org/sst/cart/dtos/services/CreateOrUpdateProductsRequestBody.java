package org.sst.cart.dtos.services;

import org.sst.cart.dtos.ProductDto;

import java.time.LocalDate;

public class CreateOrUpdateProductsRequestBody {
    Long userId;
    LocalDate date;
    ProductDto[] products;

    public CreateOrUpdateProductsRequestBody(Long userId, LocalDate date, ProductDto[] products) {
        this.userId = userId;
        this.date = date;
        this.products = products;
    }
}