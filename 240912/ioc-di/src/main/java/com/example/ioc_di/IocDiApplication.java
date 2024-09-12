package com.example.ioc_di;

import com.example.ioc_di.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class IocDiApplication {
//    public static void main(String[] args) {
////        SpringApplication.run(IocDiApplication.class, args);
//
//    }


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);
        MemberService memberService2 = applicationContext.getBean(MemberService.class);

        System.out.println("MemberService1 bean reference: " + System.identityHashCode(memberService));
        System.out.println("MemberService2 bean reference: " + System.identityHashCode(memberService2));


        Member member = new Member();
        memberService.join(member);

        Member member2 = new Member();
        memberService.join(member2);

    }

}
