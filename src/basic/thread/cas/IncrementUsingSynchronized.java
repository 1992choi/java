package basic.thread.cas;

import java.util.ArrayList;
import java.util.List;

/*
    - 원자적 연산
      - 컴퓨터 과학에서 사용하는 원자적 연산(atomic operation)의 의미는 해당 연산이 더 이상 나눌 수 없는 단위로 수행된 다는 것을 의미한다.
      - 원자적이지 않은 연산을 멀티스레드 환경에서 실행하면, 의도와 달리 계산된다.
        - Ex. 1씩 증가하는 메서드를 1000번 호출하면, 최종적으로 result=1000을 기대.
              하지만 실행결과는 1000보다 작은 값이 출력된다.

    - 해결방안 (synchronized 사용)
      - synchronized를 통해서 임계 영역을 만들어 연산 자체를 원자적으로 묶어줄 수 있다.
 */

public class IncrementUsingSynchronized {

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
        private int value;

        public synchronized void increment() {
            value++;
        }

        public synchronized int get() {
            return value;
        }
    }

}
