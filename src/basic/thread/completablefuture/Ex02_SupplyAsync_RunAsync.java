package basic.thread.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    supplyAsync() / runAsync()
    - CompletableFuture는 비동기 작업을 생성하고 실행하는 시작 메서드로 supplyAsync()와 runAsync() 를 제공한다
    - CompletableFuture는 비동기 작업을 실행하기 위해 내부적으로 ForkJoinPool.commonPool()의 스레드 풀을 사용하며 선택적으로 ThreadPoolExecutor를 사용할 수 있다
    - 가장 큰 차이점은 반환값의 유무이다.
      - supplyAsync : 반환값 O
      - runAsync : 반환값 X

    supplyAsync()
    - 정적 메서드로서 비동기 작업을 시작하고 작업 수행 후 결과를 반환한다
    - AsyncSupply()는 다음 작업으로 결과를 제공하기 위해 비동기적으로 수행해야 할 경우 사용할 수 있다

    runAsync()
    - 정적 메서드로서 비동기 작업을 시작하고 작업 수행 후 완료한다
    - runAsync()는 보통 실행 로그를 남기거나 독립적인 백그라운드 작업 또는 다음 작업에서 결과를 기다리지 않고 다른 작업을 수행해야 할 경우 사용할 수 있다
 */
public class Ex02_SupplyAsync_RunAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        supplyAsync();
        runAsync();
    }

    public static void supplyAsync() {
        MyService service = new MyService();

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 가 비동기 작업을 시작합니다");
            service.getData().stream().forEach(System.out::println);
        });

        cf.join();
        System.out.println("메인 스레드 종료");
    }

    public static void runAsync() {
        MyService service = new MyService();

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 가 비동기 작업을 시작합니다");
            service.getData().stream().forEach(System.out::println);
        });

        cf.join();
        System.out.println("메인 스레드 종료");
    }

    static class MyService {

        public List<Integer> getData() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return Arrays.asList(1, 2, 3);
        }

    }

}
