package thread.org.ThreadingProblems;

import com.sun.source.tree.SynchronizedTree;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{
    AtomicInteger visitor;

    public VisitorCount() {
        this.visitor = new AtomicInteger(0);
    }

    public int getVisitor() {
        return visitor.get();
    }

    @Override
    public void run() {
//        synchronized(this)
//        {
            visitor.getAndAdd(1);
//        }
    }
}
