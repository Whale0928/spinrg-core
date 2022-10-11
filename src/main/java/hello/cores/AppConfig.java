package hello.cores;

import hello.cores.discount.DiscountPolicy;
import hello.cores.discount.RateDiscountPolicy;
import hello.cores.member.MemberService;
import hello.cores.member.MemberServiceImpl;
import hello.cores.member.MemoryMemberRepository;
import hello.cores.order.OrderService;
import hello.cores.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository()
        );
    }
    @Bean
    public MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
