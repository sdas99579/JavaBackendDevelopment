package thread.org;

public class Client {
    public static void main(String[] args) {
        System.out.println("Current Thread "+ Thread.currentThread());
        Task temp = new Task();
        Thread t = new Thread(temp);
        t.start();
        Task2 t2=new Task2();
        t2.start();
    }
}
