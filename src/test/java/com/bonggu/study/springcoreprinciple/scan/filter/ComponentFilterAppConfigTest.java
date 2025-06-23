package com.bonggu.study.springcoreprinciple.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = ac.getBean("beanA", BeanA.class);// MyIncludeComponent가 붙은 BeanA는 빈으로 등록된다.

        Assertions.assertThat(beanA).isNotNull();

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        );

    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    /**
     * FilterType
     * 1. ANNOTATION: 애노테이션을 인식해서 필터링
     * 2. ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 필터링
     * 3. ASPECTJ: AspectJ 패턴을 인식해서 필터링
     *  - ex) com.bonggu.study.springcoreprinciple.scan.filter..*Service
     * 4. REGEX: 정규 표현식을 인식해서 필터링
     * *  - ex) com\.bonggu\.study\.springcoreprinciple\.scan\.filter\..*
     * 5. CUSTOM: TypeFilter를 구현해서 필터링
     * * @ComponentScan
     */
    static class ComponentFilterAppConfig {
    }
}
