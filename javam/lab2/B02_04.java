import java.util.Scanner;

public class ScalarProductDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = scanner.nextInt();
        double[] vector1 = new double[n];
        double[] vector2 = new double[n];
        System.out.println("Enter the elements of the first vector:");
        for (int i = 0; i < n; i++) {
            vector1[i] = scanner.nextDouble();
        }
        System.out.println("Enter the elements of the second vector:");
        for (int i = 0; i < n; i++) {
            vector2[i] = scanner.nextDouble();
        }
        double scalarProduct = 0.0;
        for (int i = 0; i < n; i++) {
            scalarProduct += vector1[i] * vector2[i];
        }
        System.out.println("Scalar product: " + scalarProduct);
    }
}
