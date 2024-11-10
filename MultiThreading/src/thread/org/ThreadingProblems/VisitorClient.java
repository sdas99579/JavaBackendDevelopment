package thread.org.ThreadingProblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VisitorClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        VisitorCount visitorCount = new VisitorCount();
        for (int i = 0; i < 20000; i++) {
            executorService.submit(visitorCount);

        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Visitors Counts are "+ visitorCount.getVisitor());
    }
}
