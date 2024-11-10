package Exception;

import java.io.IOException;

public class Demo {
    public void test1() throws IOException
    {
        throw new IOException();
    }
    public void test2() throws IOException
    {
        test1();
    }

    public static void main(String[] args) throws IOException {
        Demo d = new Demo();
        d.test2();
        System.out.println("I am in main");
    }
}
