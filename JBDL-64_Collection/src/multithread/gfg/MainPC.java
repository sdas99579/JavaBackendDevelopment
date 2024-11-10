package multithread.gfg;

public class MainPC {
    public static void main(String[] args) {
        BufferSpaceForPC bufferSpaceForPC = new BufferSpaceForPC();
        Producer producer = new Producer(bufferSpaceForPC);
        Consumer consumer = new Consumer(bufferSpaceForPC);
        producer.start();
        consumer.start();
    }
}
