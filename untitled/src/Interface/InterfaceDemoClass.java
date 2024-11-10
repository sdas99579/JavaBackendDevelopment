package Interface;

public class InterfaceDemoClass implements InterfaceDemo{
    @Override
    public int getValue()
    {
        return 0;
    }

    @Override
    public String getName() {
        return "InterfaceDemo";
    }
    //    static String getStaticMethod()
//    {
//        return "Static method in parent";
//    }

}
