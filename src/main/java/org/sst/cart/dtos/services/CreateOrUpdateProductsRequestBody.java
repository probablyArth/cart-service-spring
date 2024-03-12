package org.sst.cart.dtos.services;

import org.sst.cart.dtos.ProductDto;

import java.time.LocalDate;

public class CreateOrUpdateProductsRequestBody {
    public Long userId;
    public LocalDate date;
    public ProductDto[] products;

    public CreateOrUpdateProductsRequestBody(Long userId, LocalDate date, ProductDto[] products) {
        this.userId = userId;
        this.date = date;
        this.products = products;
    }
}