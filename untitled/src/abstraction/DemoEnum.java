package abstraction;

public class DemoEnum {

    public static void main(String[] args) {
//        System.out.println(EnumDemo.valueOf("SUNDAY"));
        for(EnumDemo d: EnumDemo.values())
        {
            System.out.println(d.id);
            System.out.println(d.val);
        }
    }
}
