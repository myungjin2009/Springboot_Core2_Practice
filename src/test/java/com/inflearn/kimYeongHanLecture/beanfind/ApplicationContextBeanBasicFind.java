package com.inflearn.kimYeongHanLecture.beanfind;

import com.inflearn.kimYeongHanLecture.AppConfig;
import com.inflearn.kimYeongHanLecture.member.MemberService;
import com.inflearn.kimYeongHanLecture.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBeanBasicFind {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이, 빈 타입으로 조회")
    public void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회") //별로 좋은 코드 아님, 구현에 의존하기 때문
    public void findBeanBySpecific(){
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회 실패")
    public void findFail() {
        assertThrows(NoSuchBeanDefinitionException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                ac.getBean("xxx", MemberService.class);
            }
        });
    }


}
