package com.bonggu.study.springcoreprinciple.singleton;

import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        // Given
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // When
        // threadA: 사용자 A가 10,000원을 주문
        statefulService1.order("userA", 10000);
        // threadB: 사용자 B가 20,000원을 주문
        statefulService2.order("userB", 20000);

        // Then
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 마지막 주문 가격이 출력된다.
        Assertions.assertThat(price).isEqualTo(20000); // 사용자 B의 주문 가격이 출력된다.

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}