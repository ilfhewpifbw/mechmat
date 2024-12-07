import java.util.Scanner;

public class BitManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        byte n = scanner.nextByte();
        System.out.print("Enter the bit position k: ");
        int k = scanner.nextInt();
        int result = n & ~(1 << k);
        System.out.println("Result: " + result);
    }
}
