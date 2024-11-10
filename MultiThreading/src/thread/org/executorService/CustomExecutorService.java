package thread.org.executorService;

import java.util.concurrent.*;

public class CustomExecutorService {
    public static void main(String[] args) throws InterruptedException {
        int corePool = 4;
        int maxPool = 8;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePool,maxPool,
                60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        Task task = new Task();
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(task);
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(200,TimeUnit.MILLISECONDS);// it will await main thread
        //executor service will do tasks before time (60 sec) then it will go to the next line it means max it will wait for set time (60 sec)

        System.out.println("I am at the last line");

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.schedule(task,60,TimeUnit.SECONDS);
        service.shutdown();
    }
}
