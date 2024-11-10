package multithread.gfg;

class BufferSpaceForPC {
    int buffer;
    boolean flag=false;
    synchronized public void produce_item(int item) throws InterruptedException {
        if(flag)
        {
            wait();
        }
        buffer = item;
        System.out.println("Produce item: "+ buffer);
        flag=true;
        notify();
    }
    synchronized public int consume_item() throws InterruptedException {
        if(!flag)
        {
            wait();
        }

        System.out.println("Consume item: "+ buffer);
        flag=false;
        notify();
        return buffer;
    }
}
