package inflearn.concurrency.section03;

public class Ex02 {

    public static void main(String[] args) {
        /*
            start()
            - 스레드 실행은 start() 메서드를 통해 실행해야한다.
            - start() 메서드로 시스템 콜을 통해서 커널에 커널 스레드 생성을 요청한다.
            - 만약 run()을 통해 실행하더라도 Runnable 구현체가 존재할 경우 Runnable의 run()을 통해 구현체가 실행되기는 한다.
              - 하지만 이렇게되면 새로운 스레드가 생성되지 않고 직접 호출한 스레드의 실행 스택에서 run()이 실행된다.
              - 다시말해 메인 스레드에서 실행되는 것과 동일한 것이며, 이는 스레드를 제대로 사용했다고 볼 수 없다.
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :스레드 실행중..");
            }
        });

        thread.start(); // 스레드가 만들어지고 실행된다.
//        thread.run(); // 메인 스레드에서 실행된다.
//        myRunnable.run(); // 메인 스레드에서 실행된다.

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중...");
        }
    }
}