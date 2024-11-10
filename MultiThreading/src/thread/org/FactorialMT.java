package thread.org;

import java.math.BigInteger;

public class FactorialMT implements Runnable{
    private int num;

    public FactorialMT(int num)
    {
        this.num=num;
    }
    @Override
    public void run() {
        BigInteger bigInteger = getFactorial();
        System.out.println("For num "+this.num+" Factorial is " + bigInteger + " With thread names: "+Thread.currentThread().getName());

    }
    public BigInteger getFactorial()
    {
        BigInteger bigInteger = BigInteger.ONE;
        for(int i=2;i<=this.num;i++)
        {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
