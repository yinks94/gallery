package kr.ink94.gallery.item.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * DTO for {@link kr.ink94.gallery.item.entity.Item}
 */
@Builder
@Getter
public class ItemRead {
    private final Integer id;
    private final String name;
    private final String imgPath;
    private final Integer price;
    private final Integer discountPer;
}