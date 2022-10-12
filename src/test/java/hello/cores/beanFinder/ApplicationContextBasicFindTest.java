package hello.cores.beanFinder;

import hello.cores.AppConfig;
import hello.cores.member.MemberService;
import hello.cores.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test @DisplayName("Bean이름으로 조회")
    void findBean(){
        MemberService ms = ac.getBean("memberService", MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }
    @Test @DisplayName("타입으로만 조회")
    void findBeanByType(){
        MemberService ms = ac.getBean(MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }



    //구체 타입(impl)으로 조회해도 가능
    //반환 타입과 상관없이 그냥 인스턴스 타입만 보고 해도 된다.
    //물론 구체타입으로 조회하는 것은 좋지 않다.
    //구현에 의존 (DIP 위반.)
    @Test @DisplayName("구체 타입으로  조회")
    void findBeanByType2(){
        MemberService ms = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test @DisplayName("이름으로 조회 X")
    void findBeanByNameX(){
        ///MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class ,
                ()->ac.getBean("xxxxx",MemberService.class));


    }
}


