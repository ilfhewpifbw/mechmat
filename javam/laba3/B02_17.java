import java.util.Scanner;

public class Main {
    public static double sh(double x, double epsilon) {
        double sum = 0;
        double term = x;
        int k = 0;
      
        while (Math.abs(term) > epsilon) {
            sum += term;
            k++;
            term *= (x * x) / ((2 * k) * (2 * k + 1));
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Enter epsilon: ");
        double epsilon = scanner.nextDouble();
        
        double result = sh(x, epsilon);
        System.out.println("sh " + result);
    }
}
