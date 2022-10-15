package hello.cores.beanFinder;

import hello.cores.member.MemberRepository;
import hello.cores.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);


    @Configuration
    static class SameBeanConfig{
        //클래스 안에서 클래스를 선언했다는 의미는 해당 메서드 내부에서만 활용한다는 의미

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 2개 이상일 경우")
    void findBeanByDuplicate(){
        // No qualifying bean of type
        /*
         *  같은 타입의 메서드가 2개 이상일 경우 발생하는 예외
         *  MemberRepository bean = ac.getBean(MemberRepository.class);
         */
        // NoU
        assertThrows(NoUniqueBeanDefinitionException.class,
                        ()-> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("같은 타입이 둘 이상 있을 경우 Bean의 이름으로 조회하기")
    void findBeanByName(){
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("같은 타입이 둘 이상 있을 경우 모두 조회")
    void findBeanByAll() {
        //Commend + Shift + enter : 바로 넘어가기

        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "\nValue = " + beansOfType.get(key));
        }
        System.out.println(beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    

}
