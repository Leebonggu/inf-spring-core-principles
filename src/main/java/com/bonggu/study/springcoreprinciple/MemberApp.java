package com.bonggu.study.springcoreprinciple;

import com.bonggu.study.springcoreprinciple.member.Grade;
import com.bonggu.study.springcoreprinciple.member.Member;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /**
         * 스프링 컨테이터
         * 모든 객체를 스프링 컨테이너에 등록하고 관리하기 위해
         */
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = appContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.BASIC);

        memberService.join(memberA);
        memberService.join(memberB);

        Member findMemberA = memberService.findMember(memberA.getId());
        Member findMemberB = memberService.findMember(memberB.getId());

        System.out.println("findMemberA = " + findMemberA.getName() + ", grade = " + findMemberA.getGrade());
        System.out.println("findMemberB = " + findMemberB.getName() + ", grade = " + findMemberB.getGrade());
    }
}
