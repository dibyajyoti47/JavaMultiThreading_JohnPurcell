package p5_producer_consyumer_lowlevel;

import java.util.Scanner;

public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer Thread Running..");
            wait();
            System.out.println("Resumed !!");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();  // it will still not release the lock
            System.out.println("but I will have to go to sleep for 5 secs then I will release the lock.");
            Thread.sleep(5000); // after this sleeping time only the lock will be released.
        }
    }

}
