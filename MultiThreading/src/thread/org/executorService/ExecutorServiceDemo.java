package thread.org.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task task = new Task();

        for (int i = 0; i < 20; i++) {

                System.out.println("Inside thread "+ Thread.currentThread().getName());
            executorService.submit(task);
        }

//        executorService.submit(task);
        executorService.shutdown();
//        Thread.sleep(500);
//        executorService.shutdownNow();//it shutdowns all task when it comes to this line
//        executorService.submit(task);
    }
}
