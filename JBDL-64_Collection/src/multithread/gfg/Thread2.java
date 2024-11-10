package multithread.gfg;

public class Thread2 implements Runnable{

    @Override
    public void run() {
//        Thread.currentThread().setPriority(7);
        for(int i=0;i<5;i++)
        {
            System.out.println("Thread Name--->"+ Thread.currentThread().getName() + "--value--> "+i);
        }
//        System.out.println(Thread.currentThread().getPriority());
    }
}
