package org.sst.cart.services;

import org.springframework.stereotype.Service;
import org.sst.cart.dtos.ProductDto;

@Service
public class ProductService extends HttpService {
    public ProductService() {
        this.init("https://fakestoreapi.com/products");
    }

    public ProductDto[] getAllProducts() {
        return this.client.getForObject("/", ProductDto[].class);
    }

    public ProductDto getProductById(Long productId) {
        return this.client.getForObject("/" + productId, ProductDto.class);
    }
}