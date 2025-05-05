package kr.ink94.gallery.cart.controller;


import jakarta.servlet.http.HttpServletRequest;
import kr.ink94.gallery.account.helper.AccountHelper;
import kr.ink94.gallery.cart.dto.CartRead;
import kr.ink94.gallery.cart.dto.CartRequest;
import kr.ink94.gallery.cart.service.CartService;
import kr.ink94.gallery.item.dto.ItemRead;
import kr.ink94.gallery.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final CartService cartService;
    private final ItemService itemService;
    private final AccountHelper accountHelper;

    @GetMapping("/api/cart/items")
    public ResponseEntity<?> readAll(HttpServletRequest request){
        Integer memberId = accountHelper.getMemberId(request);
        List<CartRead> carts = cartService.findAll(memberId);
        List<Integer> itemIds = carts.stream().map(CartRead::getItemId).toList();
        List<ItemRead> items = itemService.findAll(itemIds);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/api/carts")
    public ResponseEntity<?> push(HttpServletRequest request,
                                  @RequestBody CartRequest cartRequest){

        logger.debug("CartController push");
        Integer memberId = accountHelper.getMemberId(request);
        CartRead cart = cartService.find(memberId, cartRequest.getItemId());
        if( cart == null ){
            logger.debug("cart exist");
            cartService.save(cartRequest.toEntity(memberId));
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/cart/items/{itemId}")
    public ResponseEntity<?> remove(HttpServletRequest request,
                                   @PathVariable("itemId") Integer itemId){
        Integer memberId = accountHelper.getMemberId(request);
        cartService.remove(memberId, itemId);
        return ResponseEntity.ok().build();
   }
}
