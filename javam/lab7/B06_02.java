import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public static List<String> findPhoneNumbers(String text) {
        String phonePattern = "\\+?[0-9\\-\\(\\) ]{7,15}";

        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(text);

        List<String> phoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }

        return phoneNumbers;
    }

    public static void main(String[] args) {
        String text = """
                +1-800-555-0199, (123) 456-7890, 9876543210,
                555-1234, +44 20 7946 0958, +380(50)123-45-67.
                """;

        List<String> phoneNumbers = findPhoneNumbers(text);

        System.out.println("Found phone numbers:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}
