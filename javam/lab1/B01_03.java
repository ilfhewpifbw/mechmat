public class Main {
    public static void main(String[] args) {
        int p = 1;
        
        try {
            for (String arg: args) {
                p *= Integer.ParseInt(arg);
            };
            System.out.println(p);
        }
        catch (NumberFormatException e) {
            System.out.println("Not all arguments are integers.");
        };
    };
};
