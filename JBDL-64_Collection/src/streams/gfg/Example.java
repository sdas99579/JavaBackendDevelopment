package streams.gfg;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum=0;
        //iterative coding
        for(int i=0;i<10;i++)
        {
            if(num.get(i)%2==0)
            {
                sum += num.get(i) * num.get(i);
            }
        }
        System.out.println("Sum is "+ sum);

        //declarative coding
        int ans = num.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        }).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        }).reduce(0,new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer integer, Integer integer2)
            {
                return integer+integer2;
            }

        });
        System.out.println("Ans is "+ ans);

//lamda expression of functional interface
        int ans1 = num.stream().filter(i->i%2==0)
                .map(i->i*i)
                .reduce(0,Integer::sum);
//                .reduce(0,(i,i2)->i+i2);

        System.out.println("Ans 1 is "+ans1);
    }
}
