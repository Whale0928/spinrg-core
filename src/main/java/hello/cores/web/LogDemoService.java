package hello.cores.web;

import hello.cores.common.MyLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLog> myLogProvide;
    public void login(String id) {
        MyLog myLog = myLogProvide.getObject();
        myLog.log("Service id :: "+ id);
    }

}
