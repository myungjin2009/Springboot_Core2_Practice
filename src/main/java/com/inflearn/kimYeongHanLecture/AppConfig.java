package com.inflearn.kimYeongHanLecture;

import com.inflearn.kimYeongHanLecture.discount.DiscountPolicy;
import com.inflearn.kimYeongHanLecture.discount.FixDiscountPolicy;
import com.inflearn.kimYeongHanLecture.discount.RateDiscountPolicy;
import com.inflearn.kimYeongHanLecture.member.*;
import com.inflearn.kimYeongHanLecture.order.OrderService;
import com.inflearn.kimYeongHanLecture.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
