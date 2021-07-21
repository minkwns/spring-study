package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 얘가 객체 생성과 연결을 담당하게 됨. 이로써 DIP를 완성하게 됨. 이로써 Impl 클래스는 추상에만 의존하면 된다. Impl입장에선 의존성을 주입하는 것처럼 느낀다.

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 리팩토링을 하게 되는 경우, 역할이 다 드러나게 됨. 중복도 제거가 됨.
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // AppConfig 에서 설정을 통한 DIP 해결을 했기 때문에 가능함.
    }

}
