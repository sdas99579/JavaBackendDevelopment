package Exception;

import java.io.Closeable;
import java.io.IOException;

public class AutoCloseableDemo implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("I am inside close method");
    }
    public void test()
    {
        System.out.println("I am in test");
    }

    public static void main(String[] args) {
        try(AutoCloseableDemo d = new AutoCloseableDemo())
        {
            d.test();
        }catch (Exception e)
        {
            System.out.println(e);
        }

        //try with resources is equal to try with finally
    }
}
