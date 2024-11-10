package NotificationPkg;

import org.springframework.stereotype.Component;

@Component
public class EmailGateway {

    public  void sendEmail(String email){
        System.out.println(email);
    }
}
