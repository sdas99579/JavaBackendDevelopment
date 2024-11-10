package streams.gfg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("khgfkjhgf", "kk", "", "kuhjkjhgfh");
        //length of string >5 trim to length 5
        //you have check first and last element of string same or not
        //if it is same collect it in list
        //using stream

       List<String> l =  list.stream().filter(str->str.length()>0).map(str->str.substring(0,Math.min(str.length(),5)))
                .filter(str->str.charAt(0)==str.charAt(str.length()-1))
                .collect(Collectors.toList());

       System.out.println(l);
    }
}
