package hello.cores.discount;

import hello.cores.member.Gradle;
import hello.cores.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int dscount(Member member, int price) {
        if(member.getGrade()== Gradle.VIP) {
            return price * discountPercent /100;
        }else{
            return 0;
        }
    }
}



