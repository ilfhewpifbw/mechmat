import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Abiturient[] abiturients = {
            new Abiturient("Kate", "Street 1", "1234567890", new int[]{80, 90, 70, 85, 95}),
            new Abiturient("May", "Street 2", "0987654321", new int[]{65, 70, 60, 80, 75}),
            new Abiturient("Liza", "Street 3", "1112233445", new int[]{90, 95, 100, 98, 92}),
        };

        Abiturient[] filteredAbiturients = Abiturient.filterByMarksLessThan(abiturients, 400);
        System.out.println("Abiturients with total marks less than 400:");
        for (Abiturient abiturient : filteredAbiturients) {
            System.out.println(abiturient);
        }

        Abiturient[] topAbiturients = Abiturient.topNAbiturients(abiturients, 2);
        System.out.println("\nTop 2 students with the highest marks:");
        for (Abiturient abiturient : topAbiturients) {
            System.out.println(abiturient);
        };
    };
};
    

class Abiturient {
    private String name;
    private String address;
    private String phone;
    private int[] marks;

    public Abiturient() {
        this.name = "";
        this.address = "";
        this.phone = "";
        this.marks = new int[5];
    }

    public Abiturient(String name, String address, String phone, int[] marks) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public Abiturient(Abiturient other) {
        this.name = other.name;
        this.address = other.address;
        this.phone = other.phone;
        this.marks = Arrays.copyOf(other.marks, other.marks.length);
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phone + ", Marks: " + Arrays.toString(marks);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Abiturient that = (Abiturient) obj;
        return name.equals(that.name) && address.equals(that.address) && phone.equals(that.phone) && Arrays.equals(marks, that.marks);
    }
    
    public int sumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
    
    public static Abiturient[] filterByMarksLessThan(Abiturient[] abiturients, int threshold) {
        ArrayList<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.sumOfMarks() < threshold) {
                result.add(abiturient);
            }
        }
        return result.toArray(new Abiturient[0]);
    }
    
    public static Abiturient[] topNAbiturients(Abiturient[] abiturients, int n) {
        Arrays.sort(abiturients, Comparator.comparingInt(Abiturient::sumOfMarks).reversed());
    
        return Arrays.copyOfRange(abiturients, 0, Math.min(n, abiturients.length));
    };
};
