package com.bonggu.study.springcoreprinciple.beanFind;

import com.bonggu.study.springcoreprinciple.AppConfig;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import com.bonggu.study.springcoreprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextFindBasicTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + context.getBean("memberService", MemberService.class));

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("memberService = " + context.getBean("memberService", MemberService.class));

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체적인 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = context.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService = " + context.getBean("memberService", MemberService.class));

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 없는 빈 조회")
    void findBeanByName3() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean("xxxx", MemberService.class);
        });
    }
}
