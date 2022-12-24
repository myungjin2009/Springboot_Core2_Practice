package com.inflearn.kimYeongHanLecture.order;

import com.inflearn.kimYeongHanLecture.discount.DiscountPolicy;
import com.inflearn.kimYeongHanLecture.member.Member;
import com.inflearn.kimYeongHanLecture.member.MemberRepository;
import com.inflearn.kimYeongHanLecture.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
