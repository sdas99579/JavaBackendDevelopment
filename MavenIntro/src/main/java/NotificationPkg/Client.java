package NotificationPkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("NotificationPkg");

        NotificationService n = (NotificationService) applicationContext.getBean("notificationService");

        n.sendMsg("My code is 9347");
        n.sendEmail("My email is sdas99579@gmail.com");

    }
}
