package inheritance;

public class client {

    public static void main(String[] args) {
        child Child = new child();
        Child.setMoney(20);
        System.out.println(Child.getMoney());
        parent1 Parent1 = new parent1();
        Parent1.setMoney(50);
        System.out.println(Parent1.getMoney());
    }
}
