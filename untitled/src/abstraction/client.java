package abstraction;

public class client {
    public static void main(String[] args) {
        AbstractionDemo a = new AbstractionDemo(){};

        System.out.println(a.print());
//        Demo d = new Demo();
//        Demo.Demo1 d1 =d.new Demo1();
//        Demo.Demo1 d2 = new Demo().new Demo1();
//        d2.print1();


        Demo.Demo1 d1 = new Demo.Demo1();
    }

}
