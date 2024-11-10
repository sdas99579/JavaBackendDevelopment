package multithread.gfg;
class Bracket{
//    synchronized public void printBrackets(char open, char close)
public void printBrackets(char open, char close)
    {
        synchronized (this)
        {
            for(int i=0;i<10;i++)
            {
                if(i<5)
                    System.out.print(open);
                else
                    System.out.print(close);
            }
            System.out.println();
        }


            try {
                for(int i=0;i<10;i++)
                {
                    Thread.sleep(25);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

    }
}
public class SyncMethod {
    public static void main(String[] args) {
        Bracket brackets =  new Bracket();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for(int i=0;i<5;i++)
                {

                    brackets.printBrackets('[',']');
                }
                long endTime = System.currentTimeMillis();


                System.out.println("Time taken by Thread1: "+(endTime-startTime));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for(int i=0;i<5;i++)
                {
                    brackets.printBrackets('{','}');
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken by Thread2: "+(endTime-startTime));
            }
        });


        thread1.start();
        thread2.start();
    }
}


//synchronized method 4000ms~
//synchronized block 2500ms~
