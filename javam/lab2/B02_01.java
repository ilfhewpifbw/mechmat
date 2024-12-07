import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter size: ");
        int n = scanner.nextInt();
        
        double[] nums = new double[n];
        
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextDouble();
        };
        
        System.out.println("Minimum: " + minimumNum(nums));
    };
    
    public static double minimumNum(double[] nums) {
        double minimum = nums[0];
        for (double number: nums) {
            if (number < minimum) {
                minimum = number;
            };
        }
        return minimum;
    }
}
