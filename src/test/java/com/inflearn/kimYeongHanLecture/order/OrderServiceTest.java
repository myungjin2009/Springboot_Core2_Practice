package com.inflearn.kimYeongHanLecture.order;

import com.inflearn.kimYeongHanLecture.AppConfig;
import com.inflearn.kimYeongHanLecture.member.Grade;
import com.inflearn.kimYeongHanLecture.member.Member;
import com.inflearn.kimYeongHanLecture.member.MemberService;
import com.inflearn.kimYeongHanLecture.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
