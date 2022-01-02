package p4_ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // threadsafe

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            queue.put(random.nextInt(10)); /* 0 to 99 */
        }
    }

    private static void consumer () throws InterruptedException {
        while(true) {
            Thread.sleep(100);
            Random random = new Random();
            if(random.nextInt(100) == 0) {
                Integer someValue = queue.take();
                System.out.println("Taken value: "+someValue+"; Queue size is: "+queue.size());
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
