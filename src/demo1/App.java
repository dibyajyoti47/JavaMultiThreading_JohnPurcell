package demo1;

public class App {
    public static void main(String[] args) {
        new Runner().start();
        new Runner().start();
    }
}


class Runner extends Thread {
    public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println("Hello "+i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}