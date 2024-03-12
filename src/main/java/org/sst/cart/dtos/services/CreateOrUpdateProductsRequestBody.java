package org.sst.cart.dtos.services;

import org.sst.cart.dtos.ProductDto;

import java.time.LocalDate;

public class CreateOrUpdateProductsRequestBody {
    public Long userId;
    public LocalDate date;
    public CartProductDto[] products;

    public CreateOrUpdateProductsRequestBody(Long userId, LocalDate date, CartProductDto[] products) {
        this.userId = userId;
        this.date = date;
        this.products = products;
    }
}