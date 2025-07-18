package com.bonggu.study.springcoreprinciple.discount;

import com.bonggu.study.springcoreprinciple.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
