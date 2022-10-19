package hello.cores.Autowired;

import hello.cores.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{
        //@Autowired하고 required 옵션 기본값을 false;
        //org.springframwork.lang.@Nullable : 주입 대상이 없으면 null대입
        //Optional<> :: 자동 주입할 대상이 없으면 Optional.empty가 대입

        @Autowired(required = false)
        public void setNoBean1(Member member){
            //없는 대상을 셋
            System.out.println("1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            //없는 대상을 셋
            System.out.println("2 = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member){
            //없는 대상을 셋
            System.out.println("3 = " + member);
        }

    }
}
