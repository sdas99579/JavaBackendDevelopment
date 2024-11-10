package multithread.gfg;

public class Producer extends Thread{
    BufferSpaceForPC bufferSpaceForPC;

    Producer(BufferSpaceForPC bufferSpaceForPC)
    {
        this.bufferSpaceForPC=bufferSpaceForPC;
    }

    @Override
    public void run()
    {
        int i=1;
        while (true)
        {
            try {
                bufferSpaceForPC.produce_item(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}
