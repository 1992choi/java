package basic.thread;

public class BinarySemaphoreEx {

    public static void main(String[] args) throws InterruptedException {
        /*
            세마포어
            - 세마포어는 공유 자원에 대한 접근을 제어하기 위해 사용되는 신호전달 메커니즘 동기화 도구이다
            - 세마포어는 정수형 변수 S와 P(Proberen: try), V(Verhogen: increment)의 두 가지 원자적 함수로 구성된 신호전달 메커니즘 동기화 도구이다
            - S는 공유 자원의 개수로서 이 개수 만큼 스레드의 접근이 허용된다
            - P 는 임계 영역을 사용하려는 스레드의 진입 여부를 결정하는 연산으로 Wait 연산이라고도 하고
              V 는 대기 중인 프로세스를 깨우는 신호(Wake-up)로 Signal 연산이라고 한다.
            - 세마포어는 카운트 변수 S 가 1인 이진 세마포어(Binary Semaphore) 와 2 이상의 양수 값을 가진 카운팅 세마포어(Counting Semaphore)로 구분할 수 있다.
            - 아래 예제는 이진 세마포어(Binary Semaphore)에 대한 예제이다.
         */

        BinarySemaphore semaphore = new BinarySemaphore();
        SharedResource resource = new SharedResource(semaphore);

        Thread t1 = new Thread(resource::sum);
        Thread t2 = new Thread(resource::sum);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종 값: " + resource.getSum());
    }
}

class BinarySemaphore {

    private int signal = 1;

    public synchronized void acquired() {
        while (this.signal == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 현재 스레드의 인터럽트 상태를 설정
            }
        }
        this.signal = 0;
    }

    public synchronized void release() {
        this.signal = 1;
        this.notify();
    }

}

class SharedResource {

    private int value = 0;
    private BinarySemaphore binarySemaphore;

    public SharedResource(BinarySemaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    public void sum() {
        binarySemaphore.acquired();
        for (int i = 0; i < 1000000; i++) {
            value++;
        }
        binarySemaphore.release();
    }

    public int getSum() {
        return value;
    }

}