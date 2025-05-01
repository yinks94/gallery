package kr.ink94.gallery.cart.service;

import kr.ink94.gallery.cart.dto.CartRead;
import kr.ink94.gallery.cart.entity.Cart;

import java.util.List;

public interface CartService {

    List<CartRead> findAll(Integer memberId);

    CartRead find(Integer memberId, Integer itemId);

    void removeAll(Integer memberId);

    void remove(Integer memberId, Integer itemId);

    void save(Cart cart);
}
