package com.inflearn.kimYeongHanLecture.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
