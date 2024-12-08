import java.io.*;
import java.util.concurrent.*;

public class MultiThreadFileProcessor {
    private static int T1 = 1000;
    private static int T2 = 2000;
    private static int T3 = 1500;

    public static void main(String[] args) throws IOException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
      
        Thread readerThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    queue.put(line);
                    System.out.println("Read line: " + line);
                    Thread.sleep(T1);
                }
                queue.put("EOF");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread writer1Thread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"))) {
                while (true) {
                    String line = queue.take();
                    if ("EOF".equals(line)) {
                        queue.put("EOF");
                        break;
                    }
                    writer.write(line + System.lineSeparator());
                    System.out.println("Processed by Writer 1: " + line);
                    Thread.sleep(T2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread writer2Thread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"))) {
                while (true) {
                    String line = queue.take();
                    if ("EOF".equals(line)) {
                        queue.put("EOF");
                        break;
                    }
                    writer.write(line + System.lineSeparator());
                    System.out.println("Processed by Writer 2: " + line);
                    Thread.sleep(T3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        readerThread.start();
        writer1Thread.start();
        writer2Thread.start();
    }
}
