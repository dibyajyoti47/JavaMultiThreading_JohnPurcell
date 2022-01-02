package p3_ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i=1; i<=5; i++) {
            executor.submit(new Processor(i));
        }
        executor.shutdown(); //it will not shutdown immediately, but it will wait for all the threads to be completed.
        System.out.println("All tasks submitted (not completed).");
        try{    executor.awaitTermination(1, TimeUnit.DAYS);    } catch (InterruptedException e) {}
    }
}

class Processor implements Runnable {
    private int id;
    public Processor(int id) {
        this.id =id;
    }

    public void run() {
        System.out.println("Starting: " +id);
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        System.out.println("Completed: "+id);
    }
}
