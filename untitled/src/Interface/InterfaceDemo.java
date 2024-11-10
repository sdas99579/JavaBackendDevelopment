package Interface;

public interface InterfaceDemo {
    int a = 10;
    int getValue();

    static String getStaticMethod()
    {
        return "Static method in parent";
    }

    default String getDefaultMethod()
    {
        return "Default method in parent";
    }
    default String getName()
    {
        return null;
    }
}
