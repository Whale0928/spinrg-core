package hello.cores.web;

import hello.cores.common.MyLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final ObjectProvider<LogDemoService> logDemoServiceProvider;
    private final ObjectProvider<MyLog> myLogProvide;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest req){
        //컨테이너가 생성 시점에 request가 없어서 문제 발생
        //해결 :  Provider 사용
        MyLog myLog = myLogProvide.getObject();

        String url = req.getRequestURL().toString();
        myLog.setRequestURL(url);
        myLog.log("Controller");
        
        LogDemoService logDemoService = logDemoServiceProvider.getObject();
        logDemoService.login("Test Id");
        return "OK";
    }
}
