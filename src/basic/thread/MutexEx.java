package basic.thread;

public class MutexEx {

    public static void main(String[] args) throws InterruptedException {
        /*
            뮤텍스
            - 뮤텍스(Mutual Exclusion) 또는 상호 배제는 공유 자원에 대한 경쟁 상태를 방지하고 동시성 제어를 위한 락 메커니즘이다
            - 스레드가 임계영역에서 Mutex 객체의 플래그를 소유하고 있으면 (락 획득) 다른 스레드가 액세스할 수 없으며, Mutex 객체 플래그가 해제된 경우(락 해제)에만 액세스할 수 있다
         */

        SharedData sharedData = new SharedData(new Mutex());

        Thread th1 = new Thread(sharedData::sum);
        Thread th2 = new Thread(sharedData::sum);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("최종 합계: " + sharedData.getSum()); // 20_000_0000. 만약 lock을 획득하는 mutex.acquired() 로직이 없으면 값은 스레드 세이프하지 않아 합계가 계속 달라진다.
    }
}

class Mutex {

    private boolean lock = false;

    public synchronized void acquired() {
        /*
            최초 진입한 스레드는 lock이 false이기 때문에 아무 문제없이 수행되지만,
            이후 들어오는 스레드는 lock이 true이기 때문에 lock을 획득한 스레드가 lock을 해제하기 전까지 무한루프를 돌며 wait 상태가 된다.
         */
        while (lock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.lock = true;
    }

    public synchronized void release() {
        this.lock = false;
        this.notify();
    }
}

class SharedData {

    private int sharedValue = 0;
    private Mutex mutex;

    public SharedData(Mutex mutex) {
        this.mutex = mutex;
    }

    public void sum() {
        try {
            mutex.acquired(); // Lock 을 획득

            for (int i = 0; i < 10_000_0000; i++) {
                sharedValue++;
            }

        } finally {
            mutex.release(); // Lock 해제
        }
    }

    public int getSum() {
        return sharedValue;
    }
}