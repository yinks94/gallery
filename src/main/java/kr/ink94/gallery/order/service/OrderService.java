package kr.ink94.gallery.order.service;

import kr.ink94.gallery.order.dto.OrderRead;
import kr.ink94.gallery.order.dto.OrderRequest;

import java.util.List;

public interface OrderService {

    // 주문 목록 조회
    List<OrderRead> findAll(Integer memberId); // ①

    // 주문 상세 조회
    OrderRead find(Integer id, Integer memberId); // ②

    // 주문 내역 저장
    void order(OrderRequest orderReq, Integer memberId); // ③
}
