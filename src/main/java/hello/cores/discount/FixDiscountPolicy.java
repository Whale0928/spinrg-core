package hello.cores.discount;

import hello.cores.member.Gradle;
import hello.cores.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDisconutPolicy")
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 정액 할인

    @Override
    public int dscount(Member member, int price) {
        if(member.getGrade()== Gradle.VIP){
            return discountFixAmount;
        }{
            return 0;
        }
    }
}
