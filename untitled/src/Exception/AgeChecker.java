package Exception;
import java.io.Closeable;
import java.io.IOException;

public class AgeChecker implements Closeable{
    int age;
    public void ageChecker(int age) throws CustomExcdeptionDemo
    {
        if(age>18)
        {
            System.out.println("Age is valid");
        }
        else
        {
            throw new CustomExcdeptionDemo("Age is not valid");
        }
    }

    public static void main(String[] args) {
//        AgeChecker a = new AgeChecker();
//        a.ageChecker(2);
        try(AgeChecker a = new AgeChecker())
        {
            a.ageChecker(2);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void close() throws IOException {

    }
}
