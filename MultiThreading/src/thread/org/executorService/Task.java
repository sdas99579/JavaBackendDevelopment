package thread.org.executorService;

public class Task implements Runnable{
    @Override
    public void run() {
//        synchronized(this) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("I am inside the thread name " + Thread.currentThread().getName());
//        }
    }
}
