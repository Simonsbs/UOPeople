import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock implements Runnable {
    private final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    public void run() {
        while (true) {
            Date now = new Date();
            System.out.println(formatter.format(now));
            try {
                Thread.sleep(1000); // Sleep for 1 second before updating the time again
            } catch (InterruptedException e) {
                System.out.println("Clock thread interrupted.");
                return;
            }
        }
    }
}
