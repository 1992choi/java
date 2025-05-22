package basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Lock & ReentrantLock
    - 자바는 1.0부터 존재한 synchronized 와 BLOCKED 상태를 통한 임계 영역 관리의 한계를 극복하기 위해, 자바 1.5부터 Lock 인터페이스와 ReentrantLock 구현체를 제공한다.
    - Lock 구현은 synchronized 구문과 마찬가지로 상호배제와 가시성 기능을 가진 동기화 기법이며 synchronized 보다 더 확장된 락 작업을 제공한다
    - Lock 구현은 락을 획득 시 블록되지 않는 비 차단 시도(tryLock()), 인터럽트가 가능한 방식으로 락을 획득하는 시도(lockInterruptibly) 및 시간 제한을 둔 방식으로 락을 획득하는 시도(tryLock(long, TimeUnit))와 같은 추가 기능을 제공한다
    - synchronized 는 블록을 벗어나면 락 해제가 자동적으로 이루어지지만 Lock 구현은 명시적으로 락을 해제해 주어야 한다.

    주요 메서드
    - void lock()
      - 락을 획득한다. 만약 다른 스레드가 이미 락을 획득했다면, 락이 풀릴 때까지 현재 스레드는 대기(WAITING)한다.
      - 이 메서드는 인터럽트에 응답하지 않는다.
    - void lockInterruptibly()
      - 락 획득을 시도하되, 다른 스레드가 인터럽트할 수 있도록 한다.
      - 만약 다른 스레드가 이미 락을 획득했다면, 현재 스레드는 락을 획득할 때까지 대기한다.
      - 대기 중에 인터럽트가 발생하면 `InterruptedException` 이 발생하며 락 획득을 포기한다.
    - boolean tryLock()
      - 락 획득을 시도하고, 즉시 성공 여부를 반환한다.
      - 만약 다른 스레드가 이미 락을 획득했다면 false를 반환하고, 그렇지 않으면 락을 획득하고 true를 반환한다.
    - boolean tryLock(long time, TimeUnit unit)
      - 주어진 시간 동안 락 획득을 시도한다.
      - 주어진 시간 안에 락을 획득하면 true를 반환한다. 주어진 시간이 지나도락을 획득하지 못한 경우 false를 반환한다.
      - 이 메서드는 대기 중 인터럽트가 발생하면 InterruptedException이 발생하며 락 획득을 포기한다.
    - void unlock()
      - 락을 해제한다.
      - 락을 해제하면 락 획득을 대기 중인 스레드 중 하나가 락을 획득할 수 있게 된다.
      - 락을 획득한 스레드가 호출해야 하며, 그렇지 않으면 IllegalMonitorStateException이 발생할 수 있다.
 */
public class LockAndReentrantLockEx {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // 락을 명시적으로 활성화
        try {
            count++;
        } finally {
            lock.unlock(); // 락을 해제, finally 블록에서 작성
        }
    }

    public int getCount() {
        lock.lock(); // 락을 명시적으로 활성화
        try {
            return count;
        } finally {
            lock.unlock(); // 락을 해제, finally 블록에서 작성
        }
    }

    public static void main(String[] args) {
        LockAndReentrantLockEx lockEx = new LockAndReentrantLockEx();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                lockEx.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                lockEx.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + lockEx.getCount());
    }

}
