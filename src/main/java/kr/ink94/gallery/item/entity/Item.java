package kr.ink94.gallery.item.entity;


import jakarta.persistence.*;
import kr.ink94.gallery.item.dto.ItemRead;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "img_path", nullable = false, length = 100)
    private String imgPath;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "discount_per", nullable = false)
    private Integer discountPer;

    @Column(name = "created", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    // 상품 조회 DTO로 변환
    public ItemRead toRead() {
        return ItemRead.builder()
                .id(id)
                .name(name)
                .imgPath(imgPath)
                .price(price)
                .discountPer(discountPer)
                .build();
    }
}
