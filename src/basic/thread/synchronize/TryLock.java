package basic.thread.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    ReentrantLock API
    - ReentrantLock 은 락 획득 과정에서 스레드가 대기하거나 차단하지 않는 API 를 지원하여 유연한 코드 구현이 가능하다

    tryLock()
    - 락 획득 여부를 즉시 반환함
    - 락 획득을 실패하더라도 스레드가 대기하거나 차단되지 않음

    lockInterruptibly()
    - 락 획득을 시도하며 인터럽트에 의해 중단 가능

    tryLock(long time, TimeUnit unit)
    - tryLock()과 유사하나 락 획득을 시도하는 시간을 제한할 수 있음
    - 시간이 경과하면 락 획득 실패하고 false를 반환

    예제
    - 아래 예제는 tryLock()에 대한 예제
    - 스레드 1이 락을 획득한 후, 스레드 2는 락을 획득하지 못하여 lock.tryLock()의 수행결과로 false를 반환한다.
    - 이후 스레드 1이 락을 해제하면 스레드 2는 락을 획득하게 되어 lock.tryLock()의 수행결과로 true를 반환한다.
 */
public class TryLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            boolean acquired = false;
            while (!acquired) {
                acquired = lock.tryLock();
                if (acquired) { // 락을 획득했을 떄의 액션
                    try {
                        System.out.println("스레드 1이 락을 획득했습니다");
                        Thread.sleep(2000); // 스레드 1이 잠시 락을 보유
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println("스레드 1이 락을 해제했습니다");
                    }
                } else {
                    System.out.println("스레드 1이 락을 획득하지 못했습니다. 잠시 대기합니다.");
                    try {
                        Thread.sleep(1000); // 1초 대기 후 다시 시도
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            boolean acquired = false;
            while (!acquired) {
                acquired = lock.tryLock();
                if (acquired) { // 락을 획득했을 떄의 액션
                    try {
                        System.out.println("스레드 2가 락을 획득했습니다");
                    } finally {
                        lock.unlock();
                        System.out.println("스레드 2가 락을 해제했습니다");
                    }
                } else {
                    System.out.println("스레드 2가 락을 획득하지 못했습니다. 잠시 대기합니다.");
                    try {
                        Thread.sleep(1000); // 1초 대기 후 다시 시도
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
