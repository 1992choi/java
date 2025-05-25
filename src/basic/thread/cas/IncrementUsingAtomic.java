package basic.thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    - 원자적 연산
      - 컴퓨터 과학에서 사용하는 원자적 연산(atomic operation)의 의미는 해당 연산이 더 이상 나눌 수 없는 단위로 수행된 다는 것을 의미한다.
      - 원자적이지 않은 연산을 멀티스레드 환경에서 실행하면, 의도와 달리 계산된다.
        - Ex. 1씩 증가하는 메서드를 1000번 호출하면, 최종적으로 result=1000을 기대.
              하지만 실행결과는 1000보다 작은 값이 출력된다.

    - 해결방안 (AtomicInteger 사용)
      - AtomicInteger 는 멀티스레드 상황에 안전하고 또 다양한 값 증가, 감소 연산을 제공한다.
      - 'AtomicInteger', 'AtomicLong', 'AtomicBoolean' 등 다양한 'AtomicXxx' 클래스룰 제공한다.
 */

public class IncrementUsingAtomic {

    public static void main(String[] args) throws InterruptedException {
        IntegerBox basicInteger = new IntegerBox();
        Runnable runnable = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }

            basicInteger.increment();
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        int result = basicInteger.get();
        System.out.println("result = " + result);
    }

    private static class IntegerBox {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        public void increment() {
            atomicInteger.incrementAndGet();
        }

        public int get() {
            return atomicInteger.get();
        }
    }

}
