package hello.cores.lfecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean , DisposableBean {
public class NetworkClient{
    private String url; //접속해야하는 주소

    public NetworkClient(){
        System.out.println("생성자 호출 , url : " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("Connect : "+url);
    }

    //연결시 호출되는 메세지
    public void call(String message){
        System.out.println("Call : "+ message);
    }

    //서비스 종료시 호추
    public void disconnect(){
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }


}

