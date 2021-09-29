package basic.thread;

class ThreadA extends Thread {

    public ThreadA(String threadName) {
        super(threadName);
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}

public class ThreadUsingClass {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ThreadA("Thread_A" + i).start();
        }
    }

}
