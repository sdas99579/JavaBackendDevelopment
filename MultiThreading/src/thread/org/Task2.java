package thread.org;

public class Task2 extends Thread{
    @Override
    public void run()
    {
        System.out.println("Name of thread: "+Thread.currentThread());
    }
}
