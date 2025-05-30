package basic.thread.executor;

import java.util.concurrent.*;

public class FutureAntiPattern {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            Future를 잘못 사용한 예시
            - Future의 get() 메서드를 호출할 때, 결과값이 아직 반환될 준비가 되지 않았다면 스레드가 기다리게 된다.
         */

        // 올바른 사용 예시 - 2초가 걸리는 작업이 병렬로 실행되므로, 약 2초가 걸린다.
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(new Task());
        Future<Integer> future2 = es.submit(new Task());
        future1.get();
        future2.get();
        System.out.println("Execution Time #1 = " + (System.currentTimeMillis() - start)); // Execution Time #1 = 2017

        // 잘못된 사용 예시 - 2초가 걸리는 작업이 순차적으로 실행되어 약 4초가 걸린다.
        start = System.currentTimeMillis();
        es = Executors.newFixedThreadPool(2);

        Future<Integer> future3 = es.submit(new Task());
        future3.get();
        Future<Integer> future4 = es.submit(new Task());
        future4.get();
        System.out.println("Execution Time #2 = " + (System.currentTimeMillis() - start)); // Execution Time #2 = 4012
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(2000);
            return 0;
        }
    }

}
