import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String filename, double[] numbers) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            for (double number : numbers) {
                dos.writeDouble(number);
            }
        }
    }

    public static List<Double> readFromFile(String filename) throws IOException {
        List<Double> numbers = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                numbers.add(dis.readDouble());
            }
        }
        return numbers;
    }

    public static void filterAndWrite(String inputFilename, String outputFilename, double a) throws IOException {
        List<Double> numbers = readFromFile(inputFilename);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFilename))) {
            for (double number : numbers) {
                if (number > a) {
                    dos.writeDouble(number);
                }
            }
        }
    }

    public static void main(String[] args) {
        String fileF = "F.dat";
        String fileG = "G.dat";
        double a = 10.0;

        double[] numbers = {5.5, 12.3, 7.8, 20.1, 3.4};

        try {
            writeToFile(fileF, numbers);

            List<Double> readNumbers = readFromFile(fileF);
            System.out.println("Numbers read from file F: " + readNumbers);

            filterAndWrite(fileF, fileG, a);
            System.out.println("File G created with numbers greater than " + a);

            List<Double> filteredNumbers = readFromFile(fileG);
            System.out.println("Numbers read from file G: " + filteredNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
