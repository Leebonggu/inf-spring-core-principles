package com.bonggu.study.springcoreprinciple.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
