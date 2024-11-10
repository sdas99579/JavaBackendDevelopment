package multithread.gfg;

public class Consumer extends  Thread{

    BufferSpaceForPC bufferSpaceForPC;
    Consumer(BufferSpaceForPC bufferSpaceForPC)
    {
        this.bufferSpaceForPC=bufferSpaceForPC;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                int item = bufferSpaceForPC.consume_item();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
