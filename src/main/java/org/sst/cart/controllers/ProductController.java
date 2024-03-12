package org.sst.cart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.sst.cart.dtos.ProductDto;
import org.sst.cart.services.ProductService;

@RestController
public class ProductController {
    final ProductService productService = new ProductService();

    @GetMapping("/products/")
    public ProductDto[] getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}/")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}