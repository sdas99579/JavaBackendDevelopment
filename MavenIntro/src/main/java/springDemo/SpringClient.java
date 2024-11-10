package springDemo;

public class SpringClient {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setId(1);
        Address address = new Address();
        address.setCity("Nagaon");
        address.setPincode("782140");
        student.setAddress(address);//Who is injecting the dependeny --- user
        //spring will start doing the same thing , spring will injecting the dependency
        //spring will inject the dependency - > IOC (control has been inverted)
    }
}
