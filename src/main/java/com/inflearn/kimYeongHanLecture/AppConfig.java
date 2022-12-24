package com.inflearn.kimYeongHanLecture;

import com.inflearn.kimYeongHanLecture.discount.DiscountPolicy;
import com.inflearn.kimYeongHanLecture.discount.FixDiscountPolicy;
import com.inflearn.kimYeongHanLecture.member.*;
import com.inflearn.kimYeongHanLecture.order.OrderService;
import com.inflearn.kimYeongHanLecture.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
