import java.time.*;
import java.util.Set;

import static java.time.Month.*;

public class DateAndTime {
    public static void main(String[] args) {
        //Better and new Updated class for date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Date and Time: "+ldt);

        System.out.println(date.withMonth(Month.MARCH.getValue()));


        LocalDate d2 = LocalDate.of(2003, FEBRUARY, 15);
        System.out.println("Bhai ka VadhDiwas:- "+d2.getDayOfWeek());

        //Get time for specific timezones
        // LocalTime t1 = LocalTime.now(ZoneId.getAvailableZoneIds());
        Set s = ZoneId.getAvailableZoneIds();
        s.forEach((str)->{
            System.out.println(str);
        });
        

        System.out.println(ZoneId.getAvailableZoneIds());

        
    }
    
}
