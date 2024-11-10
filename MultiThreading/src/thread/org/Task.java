package thread.org;

public class Task implements Runnable{
    @Override
    public void run()
    {
        System.out.println("Current Thread "+ Thread.currentThread());

    }
}
