package com.bonggu.study.springcoreprinciple;

import com.bonggu.study.springcoreprinciple.order.OrderService;
import com.bonggu.study.springcoreprinciple.order.OrderServiceImpl;
import com.bonggu.study.springcoreprinciple.discount.DiscountPolicy;
import com.bonggu.study.springcoreprinciple.discount.FixDiscountPolicy;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import com.bonggu.study.springcoreprinciple.member.MemberServiceImpl;
import com.bonggu.study.springcoreprinciple.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    @Bean
    public static MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memoryMemberRepository(), discountPolicy());
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
