package thread.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientFT {
    public static void main(String[] args) {
        Integer[] num={1,2,3,4,5,6,7,8,9,10};
        Integer[] num2={10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        List<Thread> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        Arrays.stream(num2).forEach(i->
        {
            FactorialMT factorialMT = new FactorialMT(i);
            Thread thread = new Thread(factorialMT);
            thread.start();
            list.add(thread);
        });
        list.stream().forEach(th -> {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("Time Taken is: "+(end-start));

    }
}
