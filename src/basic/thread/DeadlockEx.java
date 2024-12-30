package basic.thread;

/*
    - 교착상태(Deadlock)
      - DeadLock(교착상태) 이란 프로세스나 스레드들이 서로가 소유하고 있는 자원을 기다리며 무한히 대기하고 있는 상태를 말한다
      - 교착상태에서는 아무런 진전도 이루어지지 않아 작업이 진행되지 않는 문제가 발생한다
      - DeadLock 은 동일한 환경과 코드에서 발생할 수도 있고 발생하지 않을 수도 있다

    - 데드락 발생 조건
      - 데드락은 다음의 네 가지 필요 조건을 동시에 만족할 때 발생한다. 한 가지라도 만족하지 않으면 데드락이 발생하지 않는다

        1. 상호 배제(Mutual Exclusion)
          - 자원은 한 번에 하나의 스레드만 사용할 수 있다
        2. 점유 대기(Hold and Wait)
          - 스레드가 최소한 하나의 자원을 보유한 상태에서 다른 자원을 기다리고 있다
        3. 비선점(No Preemption)
          - 자원을 할당 받은 스레드가 자원을 스스로 반납하기 전까지 자원을 강제로 빼앗을 수 없다
        4. 순환 대기(Circular Wait)
          - 각 스레드는 순환적으로 다음 스레드가 요구하는 자원을 가지고 있어 사이클이 형성된다
 */
public class DeadlockEx {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        /*
            process1에서는 lock1을 우선 획득하고, 이후 lock2를 획득하려하지만,
            process2가 lock2를 획득한 상태라 획득에 실패한다.
            반면 process2도 lock1을 획득하려하지만, lock1은 이미 process1이 획득하고 있어서 데드락이 발생한다.
        */

        Thread thread1 = new Thread(() -> {
            process1();
        });

        Thread thread2 = new Thread(() -> {
            process2();
        });

        thread1.start();
        thread2.start();
    }

    private static void process1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " 이 lock1 을 획득하였습니다.");

            try {
                // 스레드 간의 경쟁 조건을 만들기 위해 잠시 대기
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " 이 lock2 을 획득하였습니다.");
            }
        }
    }

    private static void process2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " 이 lock2 을 획득하였습니다.");

            try {
                // 스레드 간의 경쟁 조건을 만들기 위해 잠시 대기
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " 이 lock1 을 획득하였습니다.");
            }
        }
    }
}