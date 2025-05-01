package kr.ink94.gallery.cart.repository;

import kr.ink94.gallery.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByMemberId(Integer memberId);

    Optional<Cart> findByMemberIdAndItemId(Integer memberId, Integer itemId);

    void deleteByMemberId(Integer memberId);

    void deleteByMemberIdAndItemId(Integer memberId, Integer itemId);

}
