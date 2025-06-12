package com.bonggu.study.springcoreprinciple.discount;

import com.bonggu.study.springcoreprinciple.member.Grade;
import com.bonggu.study.springcoreprinciple.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 고정 할인 금액

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
