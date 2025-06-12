package com.bonggu.study.springcoreprinciple.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
