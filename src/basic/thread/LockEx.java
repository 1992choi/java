package basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Lock & ReentrantLock
    - Lock 구현은 synchronized 구문과 마찬가지로 상호배제와 가시성 기능을 가진 동기화 기법이며 synchronized 보다 더 확장된 락 작업을 제공한다
    - Lock 구현은 락을 획득 시 블록되지 않는 비 차단 시도(tryLock()), 인터럽트가 가능한 방식으로 락을 획득하는 시도(lockInterruptibly) 및 시간 제한을 둔 방식으로 락을 획득하는 시도(tryLock(long, TimeUnit))와 같은 추가 기능을 제공한다
    - synchronized 는 블록을 벗어나면 락 해제가 자동적으로 이루어지지만 Lock 구현은 명시적으로 락을 해제해 주어야 한다

    ReentrantLock
 */
public class LockEx {

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
        LockEx lockEx = new LockEx();

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
