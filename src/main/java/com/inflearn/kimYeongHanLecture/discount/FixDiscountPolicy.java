package com.inflearn.kimYeongHanLecture.discount;

import com.inflearn.kimYeongHanLecture.member.Grade;
import com.inflearn.kimYeongHanLecture.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    //정액 할인 정책 : VIP는 무조건 1000원 할인

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
