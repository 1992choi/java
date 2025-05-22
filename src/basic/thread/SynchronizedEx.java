package basic.thread;

/*
    - 개념
      - 자바는 단일 연산 특성을 보장하기 위해 synchronized 키워드를 제공하고 있으며 synchronized 구문을 통해 모니터 영역을 동기화 할 수 있다
      - synchronized는 명시적으로 락을 구현하는 것이 아닌 자바에 내장된 락으로서 이를 암묵적인 락(Intrinsic Lock) 혹은 모니터락 (Monitor Lock) 이라고 한다
      - synchronized는 동일한 모니터를 가진 객체에 대해 오직 하나의 스레드만 임계영역에 접근할 수 있도록 보장하며 모니터의 조건 변수를 통해 스레드간 협력으로 동기화를 보장해 준다
      - synchronized가 적용된 한 개의 메서드만 호출해도 같은 모니터의 모든 synchronized 메서드까지 락에 잠기게 되어 락이 해제될 때 까지는 접근이 안되는 특징을 가지고 있다
      - 락은 스레드가 synchronized 블록에 들어가기 전에 자동 확보되며 정상적이든 비정상적이든 예외가 발생해서든 해당 블록을 벗어날 때 자동으로 해제된다

    - 종류
      - synchronized 는 모니터 락을 사용하여 동기화 할 수 있는 4가지 방법을 제공한다
        1. synchronized method
        2. static synchronized method
        3. synchronized block
        4. static synchronized block

      - static 여부까지 분류하지 않는다면, 크게 2가지로 구분할 수도 있다.
        - 메서드 동기화 방식 - synchronized method
          - 메소드 전체가 임계 영역(critical section)이 된다. 즉, 메소드 내의 모든 코드가 동기화 된다
          - 동시성 문제를 한번에 편리하게 제어할 수 있는 장점은 있으나 메서드 내 코드의 세부적인 동기화 구조를 가지기 어렵다
          - 메서드 전체를 동기화하기 때문에 동기화 영역이 클 경우 성능저하를 가져온다
          - 인스턴스 메서드 동기화 와 정적 메서드 동기화 방식이 있다
        - 블록 동기화 방식 - synchronized block
          - 특정 블록을 정해서 임계 영역(critical section)을 구성한다. 즉 블록 내의 코드만 동기화 된다
          - 메서드 동기화 방식에 비해 좀 더 세부적으로 임계영역을 정해서 필요한 블록만 동기화 구조를 가질 수 있다
          - 메서드 전체를 동기화 하는 것보다 동기화 영역이 작고 효율적인 구성이 가능하기 때문에 성능 저하가 덜하다
          - 인스턴스 블록 동기화 와 정적 블록 동기화 방식이 있다

       * 모니터 구분
         - 아래 예제에서는 static 끼리, non-static 끼리 동일한 모니터를 사용한다.
         - 이말인즉슨, 1번과 3번은 동시성이 보장된다. (2번과 4번도 마찬가지)
         - 하지만 1번과 2번은 동시성이 보장되지 않는다. (1-4 / 2-3 / 3-4 케이스도 마찬가지로 보장되지 않는다.)
    - 단점
      - synchronized 는 자바 1.0부터 제공되는 매우 편리한 기능이지만, 다음과 같은 한계가 있다.
        - 무한 대기
          - BLOCKED 상태의 스레드는 락이 풀릴 때 까지 무한 대기한다.
        - 공정성
          - 락이 돌아왔을 때 BLOCKED 상태의 여러 스레드 중에 어떤 스레드가 락을 획득할 지 알 수 없다.
          - 최악의 경우 특정 스레드가 너무 오랜기간 락을 획득하지 못할 수 있다.
      - 이런 문제를 해결하기 위해 자바 1.5부터 java.util.concurrent 라는 동시성 문제 해결을 위한 라이브러리 패키지가 추가됐다.
 */
public class SynchronizedEx {

    private int instanceCount = 0;
    private static int staticCount = 0;

    // 1. synchronized method
    public synchronized void instanceMethod() {
        instanceCount++;
        System.out.println("인스턴스 메서드 동기화: " + instanceCount);
    }

    // 2. static synchronized method
    public static synchronized void staticMethod() {
        staticCount++;
        System.out.println("정적 메서드 동기화: " + staticCount);
    }

    // 3. synchronized block
    public void instanceBlock() {
        synchronized (this) {
            instanceCount++;
            System.out.println("인스턴스 블록 동기화: " + instanceCount);
        }
    }

    // 4. static synchronized block
    public static void staticBlock() {
        synchronized (SynchronizedEx.class) {
            staticCount++;
            System.out.println("정적 블록 동기화: " + staticCount);
        }
    }

    public static void main(String[] args) {
        SynchronizedEx example = new SynchronizedEx();

        new Thread(example::instanceMethod).start();
        new Thread(example::instanceBlock).start();
        new Thread(SynchronizedEx::staticMethod).start();
        new Thread(SynchronizedEx::staticBlock).start();
    }

}
