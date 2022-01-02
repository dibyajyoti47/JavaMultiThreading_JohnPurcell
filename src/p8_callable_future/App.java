package p8_callable_future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
//            Future<?> future = executor.submit(new Callable<Void>() {     for no return type void
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration  = random.nextInt(4000);
                if(duration > 100) {
                    throw new IOException("Sleeping for too long");
                }
                System.out.println("Starting...");
                Thread.sleep(duration);
                System.out.println("Finished..");
                return duration;
//              return null    for non return type.
            }
        });

        executor.shutdown();
        try {
            System.out.println("duration was : "+ future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
