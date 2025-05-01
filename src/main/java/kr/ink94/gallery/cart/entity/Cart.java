package kr.ink94.gallery.cart.entity;

import jakarta.persistence.*;
import kr.ink94.gallery.cart.dto.CartRead;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "MEMBER_ID", nullable = false)
    private Integer memberId;

    @Column(name = "ITEM_ID", nullable = false)
    private Integer itemId;

    @CreationTimestamp
    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;

    public Cart() {
    }

    public Cart(Integer memberId, Integer itemId) {
        this.memberId = memberId;
        this.itemId = itemId;
    }

    public CartRead toRead() {
        return CartRead.builder()
                .id(id)
                .itemId(itemId)
                .build();
    }

}