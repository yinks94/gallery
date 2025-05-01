package kr.ink94.gallery.cart.service;

import jakarta.transaction.Transactional;
import kr.ink94.gallery.cart.dto.CartRead;
import kr.ink94.gallery.cart.entity.Cart;
import kr.ink94.gallery.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseCartService implements CartService {

    private final CartRepository cartRepository;


    @Override
    public List<CartRead> findAll(Integer memberId) {
        return cartRepository.findAllByMemberId(memberId).stream().map(Cart::toRead).toList();
    }

    @Override
    public CartRead find(Integer memberId, Integer itemId) {
        Optional<Cart> cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);
        return cart.map(Cart::toRead).orElse(null);
    }

    @Override
    @Transactional
    public void removeAll(Integer memberId) {
        cartRepository.deleteByMemberId(memberId);
    }

    @Override
    @Transactional
    public void remove(Integer memberId, Integer itemId) {
        cartRepository.deleteByMemberIdAndItemId(memberId, itemId);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }
}
