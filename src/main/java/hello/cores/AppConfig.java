package hello.cores;

import hello.cores.discount.FixDiscountPolicy;
import hello.cores.member.MemberService;
import hello.cores.member.MemberServiceImpl;
import hello.cores.member.MemoryMemberRepository;
import hello.cores.order.OrderService;
import hello.cores.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberervice(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
    }
}
