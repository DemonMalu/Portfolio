package Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) {
        ScheduledExecutorService tempo = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Sono passati 5 secondi!");
            tempo.shutdown();
        };

        tempo.schedule(task, 5, TimeUnit.SECONDS);
    }
}

//public class Timer {
//    public static void main(String[] args) {
//        try {
//            Thread.sleep(5000); // 5000 sono millisecondi (quindi 5 secondi)
//            System.out.println("Sono passati 5 secondi!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
