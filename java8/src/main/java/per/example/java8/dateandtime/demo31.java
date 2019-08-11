package per.example.java8.dateandtime;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class demo31 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 8, 11);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.isLeapYear());
        System.out.println(date);

        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        LocalTime time = LocalTime.of(20, 10, 12);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        LocalDateTime dt1 = LocalDateTime.of(2019, 8, 11, 20, 10, 12);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(20, 10, 12);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1);

        LocalDate date1 = dt1.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(time1);

        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();

        Duration d1 = Duration.between(LocalTime.of(13, 45, 10), time);
        Duration d2 = Duration.between(instant, now);
        System.out.println(d1.getSeconds());
        System.out.println(d2.getSeconds());

        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(threeMinutes);
    }
}
