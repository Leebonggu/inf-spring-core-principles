package com.bonggu.study.springcoreprinciple.discount;

import com.bonggu.study.springcoreprinciple.member.Grade;
import com.bonggu.study.springcoreprinciple.member.Member;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void discount() {
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(memberA, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void discountNonVIP() {
        Member memberB = new Member(2L, "memberB", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(memberB, 10000);

        assertThat(discount).isEqualTo(0);
    }
}