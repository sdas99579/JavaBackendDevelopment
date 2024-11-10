package thread.org.ThreadingProblems;

import java.util.concurrent.atomic.AtomicInteger;

public class MemoryConsistencyTask implements Runnable{
    public static AtomicInteger data = new AtomicInteger(0);
    public String type;

    public MemoryConsistencyTask(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        if(type=="W")
        {
            while(data.get()!=5)
            {
                data.getAndAdd(1);
                System.out.println("Write the value as "+ data.get());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            int temp=0;
            while(true)
            {

                if(temp!=data.get())
                {
                    temp=data.get();
                    System.out.println("Read the value as "+temp);
                }



            }
        }
    }
}
