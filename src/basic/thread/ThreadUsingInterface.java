package basic.thread;

class ThreadB implements Runnable {
    private String threadName;

    public ThreadB(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(threadName + ":" + i);
        }
    }
}

public class ThreadUsingInterface {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ThreadB("Thread_B" + i));
            thread.start();
        }
    }

}
