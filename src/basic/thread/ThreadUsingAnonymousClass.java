package basic.thread;

public class ThreadUsingAnonymousClass {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 30; j++) {
                        System.out.println(this.getName() + ":" + j);
                    }
                }
            }.start();
        }
    }

}
