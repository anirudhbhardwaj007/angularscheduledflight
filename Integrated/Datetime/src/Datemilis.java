import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class Datemilis {
    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.of(2020,3,25,13,22);
        long millis =localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(millis);


     //  Date date = new Date();
       // long millis = date.
     //   Clock clock = Clock.systemDefaultZone();
       // long millis=clock.millis();
       // System.out.println(millis);
    }
}
