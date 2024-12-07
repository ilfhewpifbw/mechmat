import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Hello, " + name);
    };
};
