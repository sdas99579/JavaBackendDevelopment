package multithread.gfg;

public class Thread2Main {
    public static void main(String[] args) {
        Thread2 temp = new Thread2();
        Thread t2 = new Thread(temp);
        t2.run();
//        t2.setPriority(7);
//        t2.start();
//        for(int i=5;i<11;i++)
//        {
//            System.out.println("Thread Name-->"+ Thread.currentThread().getName() + "--value--> "+ i);
//        }

//        System.out.println(Thread.currentThread().getPriority());
//        System.out.println(Thread2Main.this.);
    }
}
