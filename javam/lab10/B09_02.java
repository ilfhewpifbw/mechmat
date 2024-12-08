import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HotelSimulation {
    private static int SCALE = 100;
    private static int T1 = 1000 / SCALE;
    private static int T2 = 3000 / SCALE;
    private static int T3 = 2000 / SCALE;
    private static int T4 = 5000 / SCALE;

    private static int ROOM_COUNT = 5;
    private static int CLIENT_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Semaphore rooms = new Semaphore(ROOM_COUNT);
        AtomicInteger totalWaitTime = new AtomicInteger();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= CLIENT_COUNT; i++) {
            int clientId = i;
            executor.submit(() -> {
                try {
                    long arrivalTime = System.currentTimeMillis();
                    System.out.println("Client " + clientId + " waiting for a room.");
                    rooms.acquire();
                    long checkInTime = System.currentTimeMillis();
                    int waitTime = (int) (checkInTime - arrivalTime);
                    totalWaitTime.addAndGet(waitTime);

                    System.out.println("Client " + clientId + " waiting " + waitTime + " ms.");

                    int stayDuration = T3 + new Random().nextInt(T4 - T3);
                    Thread.sleep(stayDuration);
                    System.out.println("Client " + clientId + " after staying " + stayDuration + " ms.");
                    rooms.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread.sleep(T1 + new Random().nextInt(T2 - T1));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Average wait time: " + totalWaitTime.get() / (double) CLIENT_COUNT + " ms.");
    }
}
