package multithread.gfg;

import thread.org.singleton.Logging;

public class Thread1Main {
    public static void main(String[] args) {
        Logging logging = Logging.getInstance();
        Thread1 t1 = new Thread1();
        t1.start();
        for(int i=5;i<11;i++)
        {
            System.out.println("Thread Name-->"+ Thread.currentThread().getName() + "--value--> "+ i);
        }
    }
}
