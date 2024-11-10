package NotificationPkg;

import org.springframework.stereotype.Component;

@Component
public class SmsGateway {
//    private String sms;

    public  void sendMsg(String sms){
        System.out.println(sms);
    }
}
