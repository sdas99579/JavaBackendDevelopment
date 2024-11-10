package springDemo;

import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringDemoClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("projectBean.xml");
        Student s = (Student) classPathXmlApplicationContext.getBean("student");
        System.out.println(s);
        classPathXmlApplicationContext.close();
//        Resource resource = new ClassPathResource("projectBean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//
//        Student s = (Student) beanFactory.getBean("student");
//        System.out.println(s);
        //xml bean factory is not present on updatded versions
    }
}
