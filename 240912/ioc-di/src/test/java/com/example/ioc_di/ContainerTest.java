package com.example.ioc_di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ContainerTest {

    @Nested
    @DisplayName("싱글톤 테스트")
    class SingletonTest{
        @Test
        @DisplayName("싱글톤 적용 전")
        public void beforeSingleton() {
            AppConfig appConfig = new AppConfig();
            MemberService memberService1 = appConfig.memberService();
            MemberService memberService2 = appConfig.memberService();
            Assertions.assertNotEquals(memberService1, memberService2);
        }

        @Test
        @DisplayName("싱글톤 적용 후")
        public void afterSingleton() {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService1 = applicationContext.getBean("memberService", MemberService.class);
            MemberService memberService2 = applicationContext.getBean("memberService", MemberService.class);
            assertEquals(memberService1, memberService2);
        }
    }

    @Nested
    @DisplayName("Bean 주입 테스트")
    class BeanTest{

        @Test
        public void xml(){
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("XmlAppConfig.xml");
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService.getMemberRepository());
        }

        @Test
        public void configuration(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService.getMemberRepository());
        }

        @Test
        @DisplayName("Component 어노테이션 자동 빈등록")
        public void componentAnnotation(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService);
            assertNotNull(memberService.getMemberRepository());
            assertNotNull(applicationContext.getBean("groupRepository", GroupRepository.class));
        }

    }

    @Nested
    @DisplayName("자동 주입 테스트")
    class AutowiredTest{

        @Test
        @DisplayName("생성자 자동 주입")
        public void autowiredConstruct(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService, "MemberService 빈이 주입되지 않았습니다.");
            assertNotNull(memberService.getMemberRepository(), "MemberRepository가 MemberService에 주입되지 않았습니다.");
        }

        @Test
        @DisplayName("Setter 자동 주입")
        public void setterConstruct(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService, "MemberService 빈이 주입되지 않았습니다.");
            assertNotNull(memberService.getMemberRepository(), "MemberRepository가 MemberService에 주입되지 않았습니다.");
        }

        @Test
        @DisplayName("필드 자동 주입")
        public void autowiredField(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService, "MemberService 빈이 주입되지 않았습니다.");
            assertNotNull(memberService.getMemberRepository(), "MemberRepository가 MemberService에 주입되지 않았습니다.");
        }

        @Test
        @DisplayName("메서드 자동 주입")
        public void autowiredMethod(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
            MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
            assertNotNull(memberService, "MemberService 빈이 주입되지 않았습니다.");
            assertNotNull(memberService.getMemberRepository(), "MemberRepository 빈이 주입되지 않았습니다.");
        }

    }



}
