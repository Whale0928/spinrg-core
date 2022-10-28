package hello.cores.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLog {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String url){
        this.requestURL = url;
    }

    public void log(String msg){
        System.out.println("["+uuid+"]["+requestURL+"]  "+msg);
    }

    @PostConstruct
    public void init(){
        String uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create : " + this);
    }//this는 주소를 표현(인스턴스)
    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope bean close : " + this);
    }
}
