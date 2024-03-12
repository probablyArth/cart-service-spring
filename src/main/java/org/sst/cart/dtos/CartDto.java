package org.sst.cart.dtos;

import lombok.Getter;
import lombok.Setter;
import org.sst.cart.dtos.services.CartProductDto;

import java.time.LocalDate;

@Getter @Setter
public class CartDto {
    Long id;
    Long userId;
    LocalDate date;
    CartProductDto[] products;
}