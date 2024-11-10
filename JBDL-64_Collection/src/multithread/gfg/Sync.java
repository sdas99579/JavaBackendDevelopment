package multithread.gfg;
class Brackets{
    public void printBrackets(char open, char close)
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
}
public class Sync {
    public static void main(String[] args) {
        Brackets brackets =  new Brackets();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++)
                {
                    brackets.printBrackets('[',']');
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++)
                {
                    brackets.printBrackets('{','}');
                }
            }
        });


        thread1.start();
        thread2.start();
    }
}
