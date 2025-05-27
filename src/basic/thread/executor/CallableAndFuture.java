package basic.thread.executor;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            Runnable의 한계
            - return 값이 없다.
            - 값을 얻기 위해서는 main 스레드는 join()해서 기다려야한다.

            이런 문제를 해결하기 위해 Executor 프레임워크는 Callable과 Future라는 인터페이스를 도입했다.

            Executor 프레임워크의 강점
            - 요청 스레드가 결과를 받아야 하는 상황이라면, Callable을 사용한 방식은 Runnable을 사용하는 방식보다 훨씬 편리하다.
            - 스레드를 생성하거나, join()으로 스레드를 제어하거나 하는 코드도 없다.
         */

        // Runnable 사용 예시
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();
        int result1 = task.value;
        System.out.println(result1);

        // Callable과 Future 사용 예시
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result2 = future.get();
        System.out.println(result2);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                value = new Random().nextInt(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(2000);
            return new Random().nextInt(10);
        }
    }

}
