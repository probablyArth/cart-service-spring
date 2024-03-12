package org.sst.cart.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CartDto {
    Long id;
    Long userid;
    LocalDate date;
    ProductDto[] products;
}