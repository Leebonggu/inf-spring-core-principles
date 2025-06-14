package com.bonggu.study.springcoreprinciple.order;

import com.bonggu.study.springcoreprinciple.AppConfig;
import com.bonggu.study.springcoreprinciple.member.Grade;
import com.bonggu.study.springcoreprinciple.member.Member;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // Then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}