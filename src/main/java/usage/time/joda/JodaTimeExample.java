package usage.time.joda;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JodaTimeExample {

    public static void main(String[] args) {
        test_calendar();
        test_joda();
        test_date_datetime();
        test_calendar_datatime();
    }

    public static void test_calendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        System.out.println(calendar);

        // add 90 days
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");
        calendar.add(Calendar.DAY_OF_MONTH, 90);
        System.out.println(sdf.format(calendar.getTime()));
    }

    public static void test_joda() {
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        // dateTime = new DateTime();
        System.out.println(dateTime);

        // add 90 days
        dateTime = dateTime.plusDays(90);
        System.out.println(dateTime.toString("MM/dd/yyyy HH:mm:ss"));
    }

    public static void test_calendar_datatime() {
        // from Joda to JDK
        DateTime dateTime = new DateTime();
        Calendar calendar = dateTime.toCalendar(Locale.CHINESE);

        // from JDK to Joda
        dateTime = new DateTime(calendar);
    }

    public static void test_date_datetime() {
        // from Joda to JDK
        DateTime dateTime = new DateTime();
        Date date = dateTime.toDate();

        // from JDK to Joda
        dateTime = new DateTime(date);
    }
}
