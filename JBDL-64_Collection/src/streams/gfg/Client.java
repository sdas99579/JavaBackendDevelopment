package streams.gfg;

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        System.out.println(calculator.add(2,3));


        Calculator c1 = (a,b)->a+b;
        System.out.println(c1.add(2,3));

        Calculator c2 = (a,b) ->{
            System.out.println("Lambda Expression: ");
            return a+b;
        };
        System.out.println(c2.add(3,4));
        System.out.println(calculator.add(4,5));
    }
}
