package org.sst.cart.services;

import org.springframework.stereotype.Service;
import org.sst.cart.dtos.CartDto;
import org.sst.cart.dtos.ProductDto;
import org.sst.cart.dtos.services.CartProductDto;
import org.sst.cart.dtos.services.CreateOrUpdateProductsRequestBody;
import org.sst.cart.dtos.services.CreateOrUpdateProductsResponse;

import java.time.LocalDate;

@Service
public class CartService extends HttpService {
    public CartService() {
        this.init("https://fakestoreapi.com/carts");
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

    public CreateOrUpdateProductsResponse addNewProducts(Long userId, LocalDate date, CartProductDto[] products) {
        CreateOrUpdateProductsRequestBody requestBody = new CreateOrUpdateProductsRequestBody(userId, date, products);
        return client.postForObject("/", requestBody, CreateOrUpdateProductsResponse.class);
    }

    public void updateProducts(Long cartId, Long userId, LocalDate date, CartProductDto[] products) {
        CreateOrUpdateProductsRequestBody requestBody = new CreateOrUpdateProductsRequestBody(userId, date, products);
        client.put("/" + cartId, requestBody);
    }

    public void deleteCartById(Long cartId) {
        client.delete("/" + cartId);
    }
}