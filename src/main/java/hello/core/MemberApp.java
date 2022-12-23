package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VUP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("inserted Member = " + findMember.getName());
        System.out.println("original memberA = " + memberA.getName());
    }
}
