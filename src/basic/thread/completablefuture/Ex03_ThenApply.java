package basic.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    thenApply() / thenApplyAsync()
    - 결과를 받아서 (비)동기적으로 작업 결과를 조작하고 다시 결과를 반환한다.
    - thenApply()는 작업을 실행하는 시점에서 이전 작업 결과가 완료되었다면 메인 스레드에서 처리되고
      그렇지 않으면 이전과 동일한 스레드에서 처리된다.
    - thenApplyAsync()는 이전 작업 결과와 상관없이 무조건 풀 스레드에서 비동기 처리된다.

    예제설명
    - supplyAsync() 메서드의 주석 여부에 따라 위 내용을 확인 가능하다.
    - 주석있음
      - thenApply()는 작업을 실행하는 시점에 작업결과가 완료되었으므로 메인 스레드에서 처리된다.
      - thenApplyAsync()는 작업을 실행하는 시점에 작업결과가 완료되었지만 비동기 처리된다.
    - 주석없음
      - thenApply()는 작업을 실행하는 시점에 작업결과가 완료되지 않았으므로 이전과 동일한 스레드에서 처리된다.
      - thenApplyAsync()는 작업을 실행하는 시점에 작업결과가 완료되지 않았으므로 비동기 처리된다. (작업완료 여부와 상관없이 무조건 비동기 처리)

 */
public class Ex03_ThenApply {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();
        long started = System.currentTimeMillis();
        CompletableFuture<Integer> asyncFuture = CompletableFuture
                .supplyAsync(() -> {
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    return 40;
                })
                .thenApply(result -> {
                    System.out.println("thread2:" + Thread.currentThread().getName());
                    int r = myService.getData1();
                    return r + result;
                }).thenApplyAsync(result -> {
                    System.out.println("thread3:" + Thread.currentThread().getName());
                    int r = myService.getData2();
                    return r + result;
                });

        int asyncResult = asyncFuture.join();
        System.out.println("final result: " + asyncResult);
        System.out.println("총 소요 시간: " + (System.currentTimeMillis() - started));
    }

    static class MyService {

        public int getData1() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 50;
        }

        public int getData2() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 60;
        }

    }

}
