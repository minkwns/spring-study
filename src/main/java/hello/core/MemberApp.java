package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);// Spring container

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// bean에서 메서드 이름. memberService를 꺼내온 것. 두번째 파라미터는 타입.

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member); // join

        Member findMember2 = memberService.findMember(member.getId());
        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("findMember2 = " + findMember2.getName());



    }
}
