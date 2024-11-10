package Interface;

public class Client {
    public static void main(String[] args) {
        InterfaceDemoClass interfaceDemoClass = new InterfaceDemoClass();
        System.out.println(InterfaceDemo.getStaticMethod());
        System.out.println(interfaceDemoClass.getDefaultMethod());
        System.out.println(interfaceDemoClass.getName());
    }
}
