
package com.bonggu.study.springcoreprinciple.beanFind;

import com.bonggu.study.springcoreprinciple.AppConfig;
import com.bonggu.study.springcoreprinciple.member.MemberRepository;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import com.bonggu.study.springcoreprinciple.member.MemberServiceImpl;
import com.bonggu.study.springcoreprinciple.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindBasicTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시, 같은 타입이 둘 이상 있으면 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            context.getBean(MemberRepository.class);
        });
    }

    @Test
    @DisplayName("타입으로 조회시, 같은 타입이 둘 이상 있으면 빈 이름을 지정하면 된다.")
    void findBeanByTypeDuplicate2() {
        context.getBean("memberRepository1", MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(context.getBean("memberRepository1", MemberRepository.class)).isInstanceOf(MemoryMemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = context.getBeansOfType(MemberRepository.class);

        for (String s : beansOfType.keySet()) {
            System.out.println("key = " + s + " value = " + beansOfType.get(s));
        }

        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
