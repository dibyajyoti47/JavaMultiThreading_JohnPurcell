package p2_thread_synchronization;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutDown();
    }
}

class Processor extends Thread {

    public volatile boolean running =true;

    @Override
    public void run() {
        while(running) {
            System.out.println("Hi there.");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}