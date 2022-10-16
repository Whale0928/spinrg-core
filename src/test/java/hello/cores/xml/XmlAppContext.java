package hello.cores.xml;

import hello.cores.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService ms = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(ms).isInstanceOf(MemberService.class);
    }
}
