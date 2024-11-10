package thread.org.ThreadingProblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryConsistencyClient {
    public static void main(String[] args) {
        MemoryConsistencyTask task1 = new MemoryConsistencyTask("W");
        MemoryConsistencyTask task2 = new MemoryConsistencyTask("R");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(task2);
        executorService.submit(task1);


        executorService.shutdown();
    }
}
