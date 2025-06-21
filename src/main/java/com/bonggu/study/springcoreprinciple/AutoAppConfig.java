package com.bonggu.study.springcoreprinciple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 실무에서는 제외하지 않음. 예제를 위한 제외
public class AutoAppConfig {
}
