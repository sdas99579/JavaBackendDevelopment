import java.util.*;

class GFG {
    public static void main(String[] args)
    {
        Queue <Integer> q  = new LinkedList<>();
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.print(q.peek() + " " + q.size());
    }
}
