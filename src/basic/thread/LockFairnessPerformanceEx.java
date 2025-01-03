package basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    ReentrantLock 공정성 정책
    - ReentrantLock 은 두 종류의 락 공정성 설정을 지원한다.
    - 불공정 방법과 공정 방법이며 생성자에서 Boolean 인자로 공정성을 지정하게 된다. (디폴트는 불공정)

    불 공정성
    - 불 공정한 락으로 생성된 경우 경쟁 상황에서 읽기 및 쓰기 락에 대한 진입 순서는 정해지지 않으며 하나 이상의 읽기 또는 쓰기 스레드를 무기한으로 연기할 수 있으나 일반적으로 공정한 락보다 더 높은 처리량을 가진다
    - 불 공정성은 락을 획득하려는 시점에 락이 사용 중이라면 대기열에 들어가게 되고 락이 해제되었다면 대기열에 대기중인 스레드를 건너뛰고 락을 획득하게 되는 정책이다
    - 대부분의 경우 공정하게 처리해서 얻는 장점보다 불공정하게 처리해서 얻는 성능상 이점이 더 크다. 왜냐하면 락을 사용하고자 하는 스레드가 있을 때 바로 획득하게 하는 것이 대기 중인 스레드를 찾아 락을 획득하도록 처리하는 시간보다 더 빠르기 때문이다

    공정성
    - 공정성 락은 성능은 감수하더라도 기아상태(Starvation)를 방지해야 하는 상황이 꼭 필요할 경우에 좋은 해결책이 될 수 있다
 */
public class LockFairnessPerformanceEx {

    private static final int THREAD_COUNT = 4;
    private static final int ITERATIONS = 1000_000;
    private static final Lock fairLock = new ReentrantLock(true);
    private static final Lock unfairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        runTest("비공정한 락", unfairLock); // 약 105 밀리초
        runTest("공정한 락", fairLock); // 약 9771 밀리초
    }

    private static void runTest(String lockType, Lock lock) {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    lock.lock();
                    try {
                        // 자원에 대한 작업 수행
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(lockType + "의 실행 시간: " + elapsedTime + "밀리초");
    }

}
