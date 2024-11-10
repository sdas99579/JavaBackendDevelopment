package Exception;

import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        // Get the current date
        Calendar calendar = Calendar.getInstance();

        // Get the week of the year
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        // Print the current date and the week of the year
        System.out.println("Current date: " + calendar.getTime());
        System.out.println("Week of the year: " + weekOfYear);
    }
}
