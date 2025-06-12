package com.bonggu.study.springcoreprinciple.Order;

import com.bonggu.study.springcoreprinciple.discount.DiscountPolicy;
import com.bonggu.study.springcoreprinciple.discount.FixDiscountPolicy;
import com.bonggu.study.springcoreprinciple.member.Member;
import com.bonggu.study.springcoreprinciple.member.MemberRepository;
import com.bonggu.study.springcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
