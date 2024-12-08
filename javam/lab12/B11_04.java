import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "https://time.is/Kyiv";
            Document document = Jsoup.connect(url)
                    .userAgent("user")
                    .get();

            String timeFromSite = document.select("time#clock").text();
            LocalTime exactTime = LocalTime.parse(timeFromSite, DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(exactTime);
          
        } catch (IOException e) {
            System.err.println("Error fetching the time from the website: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
