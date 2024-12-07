import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size:");
        int n = scanner.nextInt();

        double[] numbers = new double[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        };
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        };
        double average = sum / n;
        System.out.println("Average: " + average);
    }
}
