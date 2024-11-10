package multithread.gfg;

import java.util.*;

class BracketsP{
    synchronized public void printBrackets(char open, char close){

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

public class MainPBrackets {
    public static void main(String[] args) {
        BracketsP brackets = new BracketsP();
        Thread Thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<5;i++)
                {
                    brackets.printBrackets('[',']');
                }
            }
        });
        Thread Thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<5;i++)
                {
                    brackets.printBrackets('{','}');
                }
            }
        });


        Thread1.start();
        Thread2.start();
    }
}