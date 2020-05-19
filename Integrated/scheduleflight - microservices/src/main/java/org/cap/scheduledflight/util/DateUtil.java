package org.cap.scheduledflight.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtil {
    public static long millis(LocalDateTime dateTime){
        long millis=  dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        return millis;
    }

}