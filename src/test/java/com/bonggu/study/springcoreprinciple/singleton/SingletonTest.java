package com.bonggu.study.springcoreprinciple.singleton;

import com.bonggu.study.springcoreprinciple.AppConfig;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService(); // -> 요청마다 객체를 생성한다.
        MemberService memberService2 = appConfig.memberService(); // -> 요청마다 객체를 생성한다.

        // 서로 다른 객체가 반환된다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 방식의 주입")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance(); // -> 객체를 생성한다.
        SingletonService singletonService2 = SingletonService.getInstance(); // -> 객체를 생성하지 않고, 이미 생성된 객체를 반환한다.

        // 같은 객체가 반환된다.
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class); // -> 요청마다 객체를 생성한다.
        MemberService memberService2 = ac.getBean("memberService", MemberService.class); // -> 요청마다 객체를 생성한다.

        // 서로 다른 객체가 반환된다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
