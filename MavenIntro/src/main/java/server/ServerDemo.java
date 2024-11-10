package server;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("Enter Your Input: ");
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        while (true)
        {
            String data = sc.nextLine();
            if(data.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("This is your input: "+data+" with the thread name "+Thread.currentThread().getName());
                }
            });
        }
    }
}
