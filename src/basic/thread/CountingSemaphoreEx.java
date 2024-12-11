package basic.thread;

public class CountingSemaphoreEx {

    public static void main(String[] args) throws InterruptedException {
        /*
            세마포어
            - 세마포어는 공유 자원에 대한 접근을 제어하기 위해 사용되는 신호전달 메커니즘 동기화 도구이다
            - 세마포어는 정수형 변수 S와 P(Proberen: try), V(Verhogen: increment)의 두 가지 원자적 함수로 구성된 신호전달 메커니즘 동기화 도구이다
            - S는 공유 자원의 개수로서 이 개수 만큼 스레드의 접근이 허용된다
            - P 는 임계 영역을 사용하려는 스레드의 진입 여부를 결정하는 연산으로 Wait 연산이라고도 하고
              V 는 대기 중인 프로세스를 깨우는 신호(Wake-up)로 Signal 연산이라고 한다.
            - 세마포어는 카운트 변수 S 가 1인 이진 세마포어(Binary Semaphore) 와 2 이상의 양수 값을 가진 카운팅 세마포어(Counting Semaphore)로 구분할 수 있다.
            - 아래 예제는 카운팅 세마포어(Counting Semaphore)에 대한 예제이다.
         */

        int permits = 10; // 최대 3개의 스레드가 동시에 작업을 수행할 수 있습니다.
        CountingSemaphore semaphore = new CountingSemaphore(permits);
        CountingSharedResource resource = new CountingSharedResource(semaphore);

        int threadCount = 5; // 전체 스레드 개수

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(resource::sum);
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("최종 값: " + resource.getSum());
    }
}

class CountingSemaphore {

    private int signal;
    private int permits;

    public CountingSemaphore(int permits) {
        this.permits = permits;
        this.signal = permits;
    }

    public void acquired() {
        synchronized (this) {
            while (this.signal == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.signal--;
        }
        System.out.println(Thread.currentThread().getName() + " 락 획득, 현재 세마포어 값: " + signal);
    }

    public synchronized void release() {
        if (this.signal < permits) { // signal 값이 permits 보다 작을 때만 증가
            this.signal++;
            System.out.println(Thread.currentThread().getName() + " 락 해제, 현재 세마포어 값: " + signal);
            notifyAll();
        }
    }

}

class CountingSharedResource {

    private int value = 0;
    private CountingSemaphore countingSemaphore;

    public CountingSharedResource(CountingSemaphore countingSemaphore) {
        this.countingSemaphore = countingSemaphore;
    }

    public void sum() {
        countingSemaphore.acquired();
        for (int i = 0; i < 1000000; i++) {
            value++;
        }
        countingSemaphore.release();
    }

    public int getSum() {
        return value;
    }

}