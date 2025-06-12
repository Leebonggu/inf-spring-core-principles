package com.bonggu.study.springcoreprinciple;

import com.bonggu.study.springcoreprinciple.member.Grade;
import com.bonggu.study.springcoreprinciple.member.Member;
import com.bonggu.study.springcoreprinciple.member.MemberService;
import com.bonggu.study.springcoreprinciple.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

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
