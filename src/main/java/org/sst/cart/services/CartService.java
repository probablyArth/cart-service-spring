package org.sst.cart.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.sst.cart.CartApplication;
import org.sst.cart.dtos.CartDto;
import org.sst.cart.dtos.ProductDto;
import org.sst.cart.dtos.services.CreateOrUpdateProductsRequestBody;
import org.sst.cart.dtos.services.CreateOrUpdateProductsResponse;

import java.time.LocalDate;

@Service
public class CartService {

    final private RestTemplate client = new RestTemplate();

    public CartService() {
        client.setUriTemplateHandler(new DefaultUriBuilderFactory("https://fakestoreapi.com/carts"));
    }

    public CartDto[] getAllCarts() {
        return client.getForObject("/", CartDto[].class);
    }

    public CartDto getCartById(Long id) {
        return client.getForObject("/" + id, CartDto.class);
    }

    public CartDto[] getCartsInADateRange(LocalDate startDate, LocalDate endDate) {
        return client.getForObject("?startdate=" + startDate + "&enddate="+endDate, CartDto[].class);
    }

    public CartDto[] getCartsByUserId(Long userId) {
        return client.getForObject("/user/" + userId, CartDto[].class);
    }

    public CreateOrUpdateProductsResponse postAddNewProducts(Long userId, LocalDate date, ProductDto[] products) {
        CreateOrUpdateProductsRequestBody requestBody = new CreateOrUpdateProductsRequestBody(userId, date, products);
        return client.postForObject("/", requestBody, CreateOrUpdateProductsResponse.class);
    }

    public CreateOrUpdateProductsResponse putUpdateProducts(Long cartId, Long userId, LocalDate date, ProductDto[] products) {
        CreateOrUpdateProductsRequestBody requestBody = new CreateOrUpdateProductsRequestBody(userId, date, products);
        return client.patchForObject("/" + cartId, requestBody, CreateOrUpdateProductsResponse.class);
    }

    public void deleteCartById(Long cartId) {
        client.delete("/" + cartId);
    }
}