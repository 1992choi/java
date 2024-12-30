package basic.thread;

/*
    - volatile
      - volatile 은 변수의 가시성과 연산의 순서를 제어하기 위해 사용하는 키워드로서 스레드 간의 데이터 일관성과 가시성을 보장하는 역할을 한다.

    - 가시성 (visibility)
      - 멀티스레드 환경에서 공유 변수의 변경 내용이 한 스레드에서 다른 스레드에게 어떻게 보이는지를 나타내는 개념을 말한다.
      - 멀티스레드 프로그래밍에서는 여러 스레드가 동시에 변수에 액세스하고 수정할 수 있기 때문에 모든 스레드에게 변수의 값이 일관되게 보여지도록 가시성이 확보되어야 한다.

    - 가시성 문제
      - CPU 캐시에서 작업한 결과가 메인 메모리에 즉시 반영 되지 않을 경우 스레드 간에 결과가 다르게 보여지는 현상을 말한다.

    - 가시성 문제와 volatile
      - 캐시 메모리 현상으로 공유 변수에 대해 스레드간 가시성 문제가 발생할 경우 volatile 키워드를 사용하면 가시성 문제를 해결할 수 있다.
      - 공유 변수에 volatile 키워드를 선언하면 CPU가 데이터 작업을 할 때 메인 메모리에서 공유변수를 직접 읽고 수정된 결과를 메모리에 즉시 반영함으로 가시성 문제를 해결한다.

    -  volatile 한계점
      - volatile 은 스레드 간 공유변수에 대한 가시성을 보장하지만 동시적 상호배제를 보장해 주지 않는다.

    - volatile과 synchronized
      - synchronized 블록을 사용하면 한 시점에 오직 하나의 쓰레드만이 동기화 영역에 접근할 수 있도록 보장해준다.
      - synchronized 블록 안에서 참조되는 모든 변수들은 메인 메모리로부터 읽어들여지고 블록을 벗어나면 그 동안 수정된 모든 변수들이 즉시 메인 메모리로 반영될 수 있도록 해준다
      - synchronized 는 상호배제와 함께 가시성의 문제까지 해결할 수 있는 기능을 포함하고 있다. (synchronized 블록 내에서는 volatile 키워드가 없어도 된다)
 */
public class VolatileEx {

    // volatile 키워드 추가
    // volatile boolean running = true;
    boolean running = true;

    public void volatileTest() {
        /*
            두 번째 스레드에서 running을 false로 변경하니, 언젠가는 첫 번째 스레드가 끝날 것처럼 보이지만,
            가시성의 문제로 첫 번째 스레드는 종료되지 않는 상태가 된다.
            이 때 가시성을 위하여 volatile 키워드를 추가하면, 첫 번째 스레드가 끝나는 것을 볼 수 있게된다.
         */

        new Thread(() -> {
            int count = 0;
            while (running) {
                count++;
            }
            System.out.println("Thread 1 종료. Count: " + count);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Thread 2 종료 중..");
            running = false;
        }).start();
    }

    public static void main(String[] args) {
        new VolatileEx().volatileTest();
    }

}