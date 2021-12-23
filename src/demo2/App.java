package demo2;

public class App {
    public static void main(String[] args) {
        new Thread(new Runner()).start();
        new Thread(new Runner()).start();
    }
}

class Runner implements Runnable {

    public void run() {
        for (int i=1; i<=5; i++) {
            System.out.println("Hello "+i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
