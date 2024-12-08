import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Toy implements Serializable {
    private String name;
    private double price;
    private int minAge;
    private int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public boolean isSuitableForAge(int age) {
        return age >= minAge && age <= maxAge;
    }

    @Override
    public String toString() {
        return String.format("Toy{name='%s', price=%.2f, minAge=%d, maxAge=%d}", name, price, minAge, maxAge);
    }
}

public class Main {
    public static void writeToysToFile(String filename, List<Toy> toys) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(toys);
        }
    }
    
    public static List<Toy> readToysFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Toy>) ois.readObject();
        }
    }

    public static List<Toy> filterToysForAge(List<Toy> toys, int age) {
        List<Toy> suitableToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.isSuitableForAge(age)) {
                suitableToys.add(toy);
            }
        }
        return suitableToys;
    }

    public static void main(String[] args) {
        String fileToys = "toys.dat";
        String fileFilteredToys = "filtered_toys.dat";
        int age = 5;

        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Ball", 150.0, 3, 8));
        toys.add(new Toy("Doll", 250.5, 2, 6));
        toys.add(new Toy("Constructor", 350.0, 5, 12));

        try {
            writeToysToFile(fileToys, toys);
            System.out.println("Toys written to file: " + fileToys);

            List<Toy> readToys = readToysFromFile(fileToys);
            System.out.println("Toys read from file: " + readToys);

            List<Toy> filteredToys = filterToysForAge(readToys, age);
            System.out.println("Toys suitable for age " + age + ": " + filteredToys);

            writeToysToFile(fileFilteredToys, filteredToys);
            System.out.println("Filtered toys written to file: " + fileFilteredToys);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
