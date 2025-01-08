package basic.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    thenCombine() / thenCombineAsync()
    - 두 개의 CompletableFuture 가 모두 완료되었을 때 특정 함수를 실행하고 그 결과를 새로운 CompletableFuture 에 저장하고 반환한다
 */
public class Ex07_ThenCombine {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        CompletableFuture<String> cf1 = myService.getData1(); // 비동기 작업 1
        CompletableFuture<String> cf2 = myService.getData2();

        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (r1, r2) -> r1 + r2); // 두 개의 작업이 비동기 적으로 실행되고 완료되면 콜백이 수행되기 때문에 병렬적인 성능 이점을 가질 수 있다.
        CompletableFuture<String> cf4 = cf3.thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " Java"));

        System.out.println("final result: " + cf4.join());
    }

    static class MyService {

        public CompletableFuture<String> getData1() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Hello ";
            });
        }

        public CompletableFuture<String> getData2() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "World";
            });
        }

    }

}
