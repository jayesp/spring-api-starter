package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.CartDto;
import com.codewithmosh.store.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
}
