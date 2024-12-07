import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "text";
        System.out.println(replaceDates(text));
    };

    public static String replaceDates(String text) {
        LocalDate currentDate = LocalDate.now();
        String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        String datePattern = "\\d{2}\\.\\d{2}\\.\\d{4}|__\\.\\.\\.___";
        String updatedText = text.replaceAll(datePattern, currentDateStr);
        return updatedText;
    }
}
