import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        String[] numbers = inputLine.split("\\s+");
                        int min = Integer.MAX_VALUE;
                        int max = Integer.MIN_VALUE;

                        for (String numStr : numbers) {
                            try {
                                int num = Integer.parseInt(numStr);
                                min = Math.min(min, num);
                                max = Math.max(max, num);
                            } catch (NumberFormatException e) {
                                out.println("Error");
                                continue;
                            }
                        }

                        String result = "Min: " + min + ", Max: " + max;
                        System.out.println("Processed result: " + result);

                        out.println(result);
                    }
                } catch (IOException e) {
                    System.err.println("Client connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
