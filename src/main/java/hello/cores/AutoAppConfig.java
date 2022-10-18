package hello.cores;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
        //컴포넌티 스캔중 필터링 할 목록들
        //configuration이 자동으로 등록되지 않도록 수정 (이미
)
public class AutoAppConfig {
}
