package kr.ink94.gallery.cart.dto;

import kr.ink94.gallery.cart.entity.Cart;
import lombok.Getter;

@Getter
public class CartRequest {

    private Integer itemId;

    public Cart toEntity(Integer memberId) {
        return new Cart(memberId, itemId);
    }
}
