public class Main {
    public static boolean isStringValid(String input) {
        int balance = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
  
    public static String removeContent(String input) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                balance--;
            }
            else if (balance == 0) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
