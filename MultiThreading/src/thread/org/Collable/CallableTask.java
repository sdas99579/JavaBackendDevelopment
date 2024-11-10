package thread.org.Collable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {
    @Override
    public String call() throws Exception {
        return "I am inside thread name "+ Thread.currentThread().getName();
    }
}
