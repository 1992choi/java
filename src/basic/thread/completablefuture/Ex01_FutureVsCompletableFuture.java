package basic.thread.completablefuture;

import java.util.concurrent.*;

/*
    CompletableFuture
    - CompletableFuture 는 비동기 프로그래밍을 쉽게 다루고 복잡한 비동기 작업을 효과적으로 처리할 수 있도록 해주는 도구로 Java 8 에 도입 되었다.
    - CompletableFuture 는 값과 상태를 설정함으로 명시적으로 완료 시킬 수 있는 Future 로서 코드의 가독성을 높이고 비동기 작업의 조합을 간단하게 처리할 수 있다
    - Java 에서 비동기 및 병렬 프로그래밍의 능력을 향상시키는 데 중요한 역할을 하고 있는 클래스이다
    - 비동기 및 병렬 작업의 효율적인 제어와 조작을 위해서는Future 보다 CompletableFuture 를 사용하는 것이 더 좋다
 */
public class Ex01_FutureVsCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureRun();
        completableFutureRun();
    }

    public static void completableFutureRun() throws ExecutionException, InterruptedException {
        int finalResult = CompletableFuture.supplyAsync(() -> {
            // 비동기 서비스 1의 작업 수행
            return 1;
        }).thenApplyAsync(result1 -> {
            // 비동기 서비스 2의 작업 수행 (service1 결과 사용)
            return result1 + 2;
        }).thenApplyAsync(result2 -> {
            // 비동기 서비스 3의 작업 수행 (service2 결과 사용)
            return result2 + 3;
        }).thenApplyAsync(result3 -> {
            // 비동기 서비스 4의 작업 수행 (service3 결과 사용)
            return result3 + 4;
        }).thenApplyAsync(result4 -> {
            // 비동기 서비스 5의 작업 수행 (service4 결과 사용)
            return result4 + 5;
        }).get();

        // 최종 결과를 얻기 위해 service5의 완료를 기다림
        System.out.println("CompletableFuture 최종 결과: " + finalResult);
    }

    public static void futureRun() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Integer> future1 = executorService.submit(new Service1());
        Future<Integer> future2 = executorService.submit(new Service2(future1));
        Future<Integer> future3 = executorService.submit(new Service3(future2));
        Future<Integer> future4 = executorService.submit(new Service4(future3));
        Future<Integer> future5 = executorService.submit(new Service5(future4));

        // 최종 결과를 얻기 위해 future5의 완료를 기다림
        int finalResult = future5.get();

        executorService.shutdown();

        System.out.println("Future 최종 결과: " + finalResult); // 15
    }

    static class Service1 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 비동기 서비스 1의 작업 수행
            return 1;
        }
    }

    static class Service2 implements Callable<Integer> {
        private Future<Integer> future;

        Service2(Future<Integer> future) {
            this.future = future;
        }

        @Override
        public Integer call() throws Exception {
            // 비동기 서비스 2의 작업 수행 (future 결과 사용)
            return future.get() + 2;
        }
    }

    static class Service3 implements Callable<Integer> {
        private Future<Integer> future;

        Service3(Future<Integer> future) {
            this.future = future;
        }

        @Override
        public Integer call() throws Exception {
            // 비동기 서비스 3의 작업 수행 (future 결과 사용)
            return future.get() + 3;
        }
    }

    static class Service4 implements Callable<Integer> {
        private Future<Integer> future;

        Service4(Future<Integer> future) {
            this.future = future;
        }

        @Override
        public Integer call() throws Exception {
            // 비동기 서비스 4의 작업 수행 (future 결과 사용)
            return future.get() + 4;
        }
    }

    static class Service5 implements Callable<Integer> {
        private Future<Integer> future;

        Service5(Future<Integer> future) {
            this.future = future;
        }

        @Override
        public Integer call() throws Exception {
            // 비동기 서비스 5의 작업 수행 (future 결과 사용)
            return future.get() + 5;
        }
    }

}
