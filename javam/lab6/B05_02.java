public class Main {
    public static boolean checkConditionA(String input) {
        if (input == null || input.length() < 2) return false;

        char firstChar = input.charAt(0);
        
        if (!Character.isDigit(firstChar) || firstChar == '0') return false;

        int numLetters = Integer.parseInt(String.valueOf(firstChar));
        String remainingPart = input.substring(1);
        
        if (remainingPart.length() != numLetters) {
            return false;
        }
        
        for (int i = 0; i < remainingPart.length(); i++) {
            if (!Character.isLetter(remainingPart.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkConditionB(String input) {
        if (input == null || input.isEmpty()) return false;

        int digitCount = 0;
        int length = input.length();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        if (digitCount != 1) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                if (Character.getNumericValue(c) == length) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkConditionC(String input) {
        if (input == null || input.isEmpty()) return false;

        int sumOfDigits = 0;
        int length = input.length();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sumOfDigits += Character.getNumericValue(c);
            }
        }

        return sumOfDigits == length;
    }

    public static void main(String[] args) {
        String input = "3abc";
        System.out.println("Condition A: " + checkConditionA(input));
        System.out.println("Condition B: " + checkConditionB(input));
        System.out.println("Condition C: " + checkConditionC(input));
    }
}
