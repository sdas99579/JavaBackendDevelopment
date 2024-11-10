package thread.org.executorService;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = newThread(r);
        return t;
    }
}
