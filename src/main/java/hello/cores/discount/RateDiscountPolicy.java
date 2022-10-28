package hello.cores.discount;

import hello.cores.annotation.MainDiscountPolicy;
import hello.cores.member.Gradle;
import hello.cores.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("mainDisconutPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Gradle.VIP) {
            return price * discountPercent /100;
        }else{
            return 0;
        }
    }
}



