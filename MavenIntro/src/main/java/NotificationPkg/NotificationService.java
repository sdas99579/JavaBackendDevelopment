package NotificationPkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
//    @Autowired
    private SmsGateway smsGateway;
    @Autowired
    private EmailGateway emailGateway;


    //constructor injection
    //@Autowired is not required for constructor injection
//    public NotificationService(SmsGateway smsGateway) {
//        this.smsGateway = smsGateway;
//    }
//setter injection
    @Autowired
    public void setSmsGateway(SmsGateway smsGateway) {
        this.smsGateway = smsGateway;
    }

    public  void sendMsg(String sms)
    {
        smsGateway.sendMsg(sms);
    }
    public  void sendEmail(String email)
    {
        emailGateway.sendEmail(email);
    }
}
