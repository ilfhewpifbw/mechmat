import java.util.regex.Pattern;

public class Main {
    public static boolean isValidExpression(String expression) {
        String validExpressionPattern = "\\s*[+-]?\\d+(\\.\\d+)?(\\s*[+\\-*/]\\s*[+-]?\\d+(\\.\\d+)?)*\\s*";

        return Pattern.matches(validExpressionPattern, expression);
    }

    public static void main(String[] args) {
        String expression =  "+2 - 57 * 33 + 25 / -4";

        System.out.println("Expression: \"" + expression + "\"");
        System.out.println("Is valid? " + isValidExpression(expression));
        System.out.println();
    }
}
