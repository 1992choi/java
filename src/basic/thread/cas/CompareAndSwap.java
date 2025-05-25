package basic.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwap {

    /*
        락 기반 방식의 문제점
        - Increment 예제 중 동시성을 고려해서 락을 사용하였다.
        - 락이 걸려 있는 동안 다른 스레드들은 해당 자원에 접근할 수 없고, 락이 해제될 때까지 대기해야 한다. (락 획득과 해제에 시간이 소요되고 이는 성능 이슈가 될 수도 있음)
          - 해당 예제에서 스레드 수와 반복 숫자를 높이면, 성능 차이가 나는 것을 확인할 수 있다.
          - 하지만, synchronized와 AtomicInteger 의 성능 차이가 꽤 나는 것을 확인할 수 있다. (synchronized를 사용하는 것이 성능이 더 좋지 않음)
          - 둘 다 내부적으로 lock을 사용할 것 같지만 사실 AtomicInteger은 lock을 사용하지 않는다.
        - 이런 문제를 해결하기 위해 락을 걸지 않고 원자적인 연산을 수행할 수 있는 방법이 있는데, 이것을 CAS(Compare-And-Swap, Compare-And-Set) 연산이라 한다.

        CAS
        - 락을 걸지 않고 원자적인 연산을 수행할 수 있는 방법
        - 락을 사용하지 않기 때문에 락 프리(lock-free) 기법이라한다.
        - 락을 완전히 대체하는 것은 아니고, 작은 단위의 일부 영역에 적용할 수 있다.

        CAS의 동작 방식
        - CAS 연산은 이렇게 원자적이지 않은 두 개의 연산을 CPU 하드웨어 차원에서 특별하게 하나의 원자적인 연산으로 묶어서 제공하는 기능이다.
        - 이것은 소프트웨어가 제공하는 기능이 아니라 하드웨어가 제공하는 기능이다. (대부분의 현대 CPU들은 CAS 연산을 위한 명령어를 제공)

        CAS(Compare-And-Swap)와 락(Lock) 방식의 비교
        - 락(Lock) 방식
          - 비관적(pessimistic) 접근법
          - 데이터에 접근하기 전에 항상 락을 획득
          - 다른 스레드의 접근을 막음
        - CAS(Compare-And-Swap) 방식
          - 낙관적(optimistic) 접근법
          - 락을 사용하지 않고 데이터에 바로 접근
          - 충돌이 발생하면 그때 재시도

        CAS 사용 시 주의사항
        - CAS를 사용하는 방식은 충돌이 드물게 발생하는 환경에서는 락을 사용하지 않으므로 높은 성능을 발휘할 수 있다.
        - 락을 사용하는 방식과 비교했을 때, 스레드가 락을 획득하기 위해 대기하지 않기 때문에 대기 시간과 오버헤드가 줄어드는 장점이 있다.
        - 그러나 충돌이 빈번하게 발생하는 환경에서는 성능에 문제가 될 수 있다.
          - 여러 스레드가 자주 동시에 동일한 변수의 값을 변경하려고 시도할 때, CAS는 자주 실패하고 재시도해야 하므로 성능 저하가 발생할 수 있다.
          - 반복문을 계속 돌기 때문에 CPU 자원을 많이 소모하게 된다.
     */

    public static void main(String[] args) {
        // 간단한 동작 방식
        AtomicInteger atomicInteger = new AtomicInteger(0);

        /*
            첫 번째 접근한 스레드라고 가정.
            - 초기값이 0이므로 1을 더하면 1일 것이라고 예상
            - 예측값이 맞으므로 true를 반환하며, 값이 1증가하여 1이 된다.
         */
        boolean result1 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result1 = " + result1 + ", value = " + atomicInteger.get()); // result1 = true, value = 1

        /*
            두 번째 접근한 스레드라고 가정.
            - 초기값이 0이므로 1을 더하면 1일 것이라고 예상
              - 하지만 이미 스레드1이 1을 더한 상황 발생.
            - 예측값이 틀렸으므로 false를 반환하고, 값 증가 없음.
         */
        boolean result2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result2 = " + result2 + ", value = " + atomicInteger.get()); // result2 = false, value = 1
    }

}
