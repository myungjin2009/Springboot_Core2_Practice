package com.inflearn.kimYeongHanLecture;

import com.inflearn.kimYeongHanLecture.member.Grade;
import com.inflearn.kimYeongHanLecture.member.Member;
import com.inflearn.kimYeongHanLecture.member.MemberService;
import com.inflearn.kimYeongHanLecture.member.MemberServiceImpl;
import com.inflearn.kimYeongHanLecture.order.Order;
import com.inflearn.kimYeongHanLecture.order.OrderService;
import com.inflearn.kimYeongHanLecture.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
