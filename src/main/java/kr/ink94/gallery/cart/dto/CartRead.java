package kr.ink94.gallery.cart.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartRead {
    private Integer id;

    private Integer itemId;
}
