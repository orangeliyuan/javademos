package per.example.java8.dateandtime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class demo33 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 8, 11);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CANADA);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(date.format(formatter));
        System.out.println(date.format(italianFormatter));

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CANADA);

        System.out.println(date.format(complexFormatter));
    }
}
