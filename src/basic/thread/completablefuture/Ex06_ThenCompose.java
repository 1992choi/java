package basic.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    thenCompose() / thenComposeAsync()
    - 인스턴스 메서드로서 (비)동기적으로 하나의 CompletableFuture 가 완료되면 그 결과를 다음 작업으로 전달하고 이어서 다음 작업을 수행할 수 있도록 해 준다.
    - 이를 통해 여러 비동기 작업을 연속적으로 실행하고 조합할 수 있다.
 */
public class Ex06_ThenCompose {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        // 비동기 작업 1
        CompletableFuture<Integer> asyncTask1 = myService.getData1(5);

        // 비동기 작업 2 : 이전 비동기 작업의 결과를 사용 하여 다른 비동기 작업 실행
        CompletableFuture<Integer> asyncTask2 = asyncTask1.thenCompose(result -> {
            return myService.getData2(result);
        });

        int finalResult = asyncTask2.get();
        System.out.println("final result: " + finalResult);
    }

    static class MyService {

        public CompletableFuture<Integer> getData1(int input) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return input * 2;
            });
        }

        // 호출 되는 함수가 비동기로 실행 된 후 반환 값이 CompletableFuture 로 되는 경우
        public CompletableFuture<Integer> getData2(int input) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return input * 2;
            });
        }

    }

}
