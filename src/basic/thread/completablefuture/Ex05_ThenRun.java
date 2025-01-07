package basic.thread.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    thenRun() / thenRunAsync()
    - 인스턴스 메서드로서 (비)동기적으로 이전 결과를 무시하고 단순한 후속 작업을 수행한다
    - thenRun()는 이전 작업 결과와 상관없이 무조건 풀 스레드에서 비동기 처리된다.
      풀 스레드는 이전과 동일한 스레드 혹은 새롭게 생성된 스레드가 될 수 있다.
    - thenRunAsync()는 이전 작업 결과가 완료되었다면 메인 스레드에서 동기 처리되고 그렇지 않으면 이전과 동일한 스레드에서 비동기 처리된다.
 */
public class Ex05_ThenRun {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        CompletableFuture<List<Integer>> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                    System.out.println("thread1:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 40;
                })
                .thenApply(result -> {
                    System.out.println("thread2:" + Thread.currentThread().getName());
                    return myService.getData1();
                });

        // 비동기 작업 2: 로깅
        CompletableFuture<Void> asyncTask2 = asyncTask1.thenRun(() -> {
            System.out.println("thread: " + Thread.currentThread().getName());
            System.out.println("비동기 작업이 완료 되었습니다.");
        });

        // 비동기 작업 1 실행 및 결과 얻기
        List<Integer> result = asyncTask1.join();
        System.out.println("비동기 작업 1 결과: " + result);

        // asyncTask2의 thenRun 작업이 완료될 때까지 대기
        asyncTask2.join();

        System.out.println("모든 작업 완료");
    }

    static class MyService {

        public List<Integer> getData1() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1, 2, 3);
        }

        public List<Integer> getData2() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(4, 5, 6);
        }

    }

}
