package basic.thread;

import java.util.LinkedList;
import java.util.Queue;

/*
    - 생산자 소비자 문제 개념
      - 생산자(Producer)
        - 데이터를 생성하는 역할을 한다.
        - 예를 들어, 파일에서 데이터를 읽어오거나 네트워크에서 데이터를 받아오는 스레드가 생산자 역할을 할 수 있다.
      - 소비자(Consumer)
        - 생성된 데이터를 사용하는 역할을 한다.
        - 예를 들어, 데이터를 처리하거나 저장하는 스레드가 소비자 역할을 할 수 있다.
      - 버퍼(Buffer)
        - 생산자가 생성한 데이터를 일시적으로 저장하는 공간이다. 이 버퍼는 한정된 크기를 가지며, 생산자와 소비자가 이 버퍼를 통해 데이터를 주고받는다.

    - 생산자 소비자 문제상황
      - 생산자가 너무 빠를 때
        - 버퍼가 가득 차서 더 이상 데이터를 넣을 수 없을 때까지 생산자가 데이터를 생성한다.
        - 버퍼가 가득 찬 경우 생산자는 버퍼에 빈 공간이 생길 때까지 기다려야 한다.
      - 소비자가 너무 빠를 때
        - 버퍼가 비어서 더 이상 소비할 데이터가 없을 때까지 소비자가 데이터를 처리한다.
        - 버퍼가 비어있을 때 소비자는 버퍼에 새로운 데이터가 들어올 때까지 기다려야 한다.

    - 문제 해결 방법
      - 버퍼가 가득차서 더 이상 데이터를 넣을 수 없다면, 생산자는 생산을 멈춘다.
      - 반대로 버퍼에서 가져갈 데이터가 없다면, 소비자는 소비를 멈춘다.
      - 이 때 한쪽이라도 공유자원에 접근한 상태로 멈추면, 더 이상 락을 획득할 수 없기 때문에 무한 대기상태에 빠질 수가 있다.
        - 가령 생산자가 락을 획득하고 생산을 하다가 버퍼가 가득차서 생산을 멈춘 후 소비될 때까지 기다릴 경우, 소비자는 락을 획득하지 못하므로 소비를 할 수 없다.
        - 즉, 소비자는 소비를 할 수도, 생산자는 소비가 되지 않으니 무한정 기다리는 상황이 발생한다.
      - 위와 같은 문제를 해결하기 위해서는 락을 반납해야하는데, 스레드 간 협력을 통해 문제를 해결할 수 있다.

    - 스레드 간 협력 : wait() & notify()
      - wait(), notify(), notifyAll() 은 모니터 객체의 조건변수와 함께 사용해서 동기화를 구현할 수 있는 동기화 메커니즘이라 할 수 있다
      - wait(), notify(), notifyAll() 은 뮤텍스(상호배제) 동기화 기법으로 충족되지 않는 동기화 문제를 해결할 수 있는 협력에 의한 동기화 장치이다
      - wait(), notify(), notifyAll() 은 반드시 synchronized 블록 안에서만 사용해야 하며 이는 스레드가 모니터 락을 확보한 상태에서 이 API 들이 작동한다는 것을 의미한다

    - wait()
      - 스레드를 대기 상태로 전환시키고 모니터 락은 해제되며 다른 스레드가 모니터 락을 획득하여 작업을 수행할 수 있다
      - 조건 변수와 함께 사용되어 특정 조건이 만족될 때까지 대기하게 되며 이를 통해 스레드 간의 효율적인 협력을 구현할 수 있다
      - 다른 스레드가 동일한 모니터 락을 획득하고 notify() 또는 notifyAll() 메서드를 호출하면 대기 중의 한 스레드 혹 모든 스레드가 깨어난다
      - 스레드는 깨어난 상태에서 바로 실행하는 것이 아니라 락을 획득해야 하며 락을 획득한 스레드는 wait() 다음 구문을 수행하게 된다
      - wait(long timeout) 을 사용하여 일정 시간 동안 대기하도록 타임아웃을 지정할 수 있으며 타임아웃이 경과하면 스레드는 자동으로 깨어난다
      - 인터럽트가 걸리면 InterruptedException 예외가 발생하고 인터럽트 된 스레드는 대기에서 깨어나게 된다. 예외 처리가 필요하다

    - notify() & notifyAll()
      - notify()는 같은 모니터의 조건 변수에서 대기 중인 스레드 중에서 임의의 하나를 깨우며 notifyAll()은 스레드 전체를 깨운다
      - 어떤 스레드가 깨어날 것인지 알 수 없으며 무작위로 선택되기 때문에 notify() 보다 notifyAll() 을 사용하는 것을 선호한다
        - notify()을 사용할 경우
          - 대기하고 있는 스레드가 소비자 5 / 생성자 1 이라고 가정할 때, notify()를 할 경우 소비자만 깨어나는 최악의 경우가 발생할 수 있다. (기아 상태 발생할 가능성 있음)
          - 반면 notifyAll()을 할 경우, 모든 스레드가 깨어난 후 순차적으로 한 번씩은 락 획득을 시도하기 때문에 가장 늦게 실행되더라도 기아 상태는 발생하지 않는다.
      - 깨어난 스레드가 다시 실행되어야 할 때는 해당 객체의 모니터 락을 다시 획득하기 위해 경쟁해야 한다
      - 스레드를 깨울 때 우선순위가 높은 스레드가 깨어날 것이라는 보장은 없다. 운영체제와 JVM의 스케줄링 정책에 따라 결정된다
      - 메서드 호출 후 synchronized 블록이 끝나기 전까지 락이 해제되지 않으며 해당 블록에서 빠져나가야 락이 해제된다

    - notify() & notifyAll() 의 한계
      - 생산자가 생산자를 깨우고, 소비자가 소비자를 깨우는 것은 비효율적이다.
        - 버퍼가 가득 찬 상태에서 생산자가 생산자를 깨울 경우, 생산을 하지 못하므로 아무 액션없이 다시 대기 상태로 빠진다.
        - 소비자가 소비자를 깨우는 것 또한 마찬가지.
        - 위에서 설명한 것처럼 notify()를 사용할 경우, 최악의 경우에는 기아 상태 발생 가능성까지 있다.
      - 이러한 비효율성을 해결하기 위해 Lock과 ReentrantLock을 사용하면 쉽게 해결할 수 있다.
        - Lock과 ReentrantLock을 사용하여, 생산자는 소비자를 깨우고 소비자는 생산자를 깨우면 비효율을 제거할 수 있다.
          - 생산자와 소비자의 대기 공간을 분리할 수 있다.
      - 참고
        - 김영한의 자바 고급1 > Object - wait, notify - 한계
        - 김영한의 자바 고급1 > Lock Condition

    - 기본 동작 구조
      - wait()은 대기하게 하고 notify()는 통지 함으로서 스레드간 상호 배제와 상호 협력으로 동기화를 구현할 수 있다
      - wait()으로 인해 락을 해제하고, notify()로 인해 락을 획득할 수 있다

    - 동기화 영역에서 발생할 수 있는 문제점
      - 스레드가 동기화 영역에서 특정한 조건이 만족될 때까지 다음으로 진행하지 못한다면 다음과 같은 문제점을 가지게 된다
        - 이미 락을 소유한 스레드가 특정한 조건이 만족 될 때까지 동기화 영역을 빠져 나오지 못하므로 다른 스레드들은 락을 무한정 기다려야 하는 상황이 발생할 수 있다
        - 특정한 조건이 만족 될 때까지 계속 반복하면서 상태를 확인(SpinLock) 해야 하므로 CPU 부하 등 쓸데없는 자원낭비로 이어질 수 있다
    - 해결 방안
      - 동기화 영역에서 특정한 조건이 만족될 때까지 다음으로 진행하지 못할 경우, 조건 변수는 좋은 해결책이 된다.
        - 이미 락을 소유한 스레드가 특정한 조건이 만족 될 때까지 가지고 있는 락을 해제하고 대기하도록 한다
        - 다른 스레드가 락을 획득한 후에 특정한 상황을 해결하고 대기 중인 스레드들을 깨우면 깨어난 스레드는 락을 다시 획득한 후 계속 프로세스를 진행하도록 한다
        - 스레드는 조건이 만족 될 때까지 계속 반복 수행 할 필요가 없으며 스레드 간 협력을 통해서 상호배제 동기화를 유지하면서 문제를 해결해 나갈 수 있다

    ----> 아래 코드는 협력을 통해서 상호배제 동기화를 유지하는 코드로 볼 수 있다.
 */
public class WaitAndNotifyEx {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        // 생산자 스레드
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    sharedQueue.produce(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "생산자");


        // 소비자 스레드
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    sharedQueue.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "소비자");

        producer.start();
        consumer.start();
    }

    static class SharedQueue {

        private Queue<Integer> queue = new LinkedList<>();
        private final int CAPACITY = 5;  // 큐의 최대 용량
        private final Object lock = new Object();

        // 아이템을 큐에 추가
        public void produce(int item) throws InterruptedException {
            synchronized (lock) {
                while (queue.size() == CAPACITY) {  // 큐가 가득 찼으면
                    System.out.println("큐가 가득 찼습니다. 생산 중지...");
                    lock.wait();  // 대기
                }

                queue.add(item);
                System.out.println("생산: " + item);

                lock.notifyAll();  // 대기 중인 모든 소비자에게 알림
            }
        }

        // 아이템을 큐에서 제거
        public void consume() throws InterruptedException {
            synchronized (lock) {
                while (queue.isEmpty()) {  // 큐가 비어 있으면
                    System.out.println("큐가 비었습니다. 소비 중지...");
                    lock.wait();  // 대기
                }

                int item = queue.poll();
                System.out.println("소비: " + item);

                lock.notifyAll();  // 대기 중인 모든 생산자에게 알림
            }
        }

    }

}


