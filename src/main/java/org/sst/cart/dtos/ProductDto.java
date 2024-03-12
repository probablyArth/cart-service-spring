package org.sst.cart.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
    Long id;
    String title;
    double price;
    String description;
}