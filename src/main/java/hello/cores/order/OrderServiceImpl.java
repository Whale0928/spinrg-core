package hello.cores.order;

import hello.cores.discount.DiscountPolicy;
import hello.cores.member.Member;
import hello.cores.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 정보 조회하고
        int discountPrice = discountPolicy.dscount(member,itemPrice); // 가격 할인 정보 조회하고.
        return new Order(memberId,itemName,itemPrice,discountPrice); // 주문 정보를 반환
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
