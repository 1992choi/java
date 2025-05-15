package basic.thread;

public class ThreadStartAndRun {

    public static void main(String[] args) {
        /*
            start()와 run()의 차이
            - start()
              - 새로운 스레드를 생성해서 run() 메서드를 실행함
              - 멀티스레딩 O
            - run()
              - 현재 메인 스레드에서 run() 메서드를 직접 실행함
              - 멀티스레딩 X (단순한 메서드 호출의 형태)

            --> Thread 객체를 만들고 run()만 호출하면 의미 없음
                - 스레드 만들고 싶으면 start()를 호출해야한다.
         */

        Thread t1 = new Thread(new RunnableWithStart());
        t1.start(); // start() : Thread-0

        Thread t2 = new Thread(new RunnableWithRun());
        t2.run(); // run() : main
    }

}

class RunnableWithStart implements Runnable {
    @Override
    public void run() {
        System.out.println("start() : " + Thread.currentThread().getName());
    }
}

class RunnableWithRun implements Runnable {
    @Override
    public void run() {
        System.out.println("run() : " + Thread.currentThread().getName());
    }
}
