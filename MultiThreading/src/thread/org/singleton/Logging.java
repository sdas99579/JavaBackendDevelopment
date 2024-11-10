package thread.org.singleton;



import java.util.Collection;
import java.util.Collections;

public class Logging {

    int num;

    private Logging(){}

    public static Logging instance;
//    public static Logging instance = new Logging(); //early initialization
//    public synchronized static Logging getInstance()
//    {
//        if(instance==null)
//        {
//            System.out.println("Null Instance");
//            instance = new Logging();
//        }
//        return instance;
//    }
        public static Logging getInstance()
        {
            if(instance==null)
            {
                synchronized (Logging.class)
                {
                    if(instance==null)
                    {
                        System.out.println("Null Instance");
                        instance = new Logging();
                    }
                }
            }
            return instance;
        }
    public void printMsg(String msg)
    {
        System.out.println("Msg is: "+ msg);
    }

    public static void main(String[] args) {
        Logging logging = Logging.getInstance();
        logging.printMsg("Instance Msg");

        Logging logging1 = Logging.getInstance();
        logging1.printMsg("Second msg");
    }
}