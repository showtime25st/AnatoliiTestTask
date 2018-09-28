package utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Utils {

    public static String getDate(String year, String month, String day) {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(new Locale("ru"))
                .format(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
    }

}
