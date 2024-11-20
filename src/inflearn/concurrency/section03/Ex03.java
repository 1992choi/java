package inflearn.concurrency.section03;

public class Ex03 {

    public static void main(String[] args) {
        /*
            스레드 종료
            - 스레드는 run() 메서드의 코드가 모두 실행되면 스레드는 자동으로 종료한다
            - 스레드는 예외가 발생할 경우 종료되며 다른 스레드에 영향을 미치지 않는다
            - 어플리케이션은 싱글스레드인 경우와 멀티스레드인 경우 종료 기준이 다르다
         */

        /*
            싱글 스레드 예제
            - 싱글 스레드(여기서는 메인 스레드 한 개를 지칭)은 순차적으로 실행되기 때문에 아래와 같이 순서대로 출력이 된다.
            - main thread 만 종료되면 어플리케이션이 종료된다
         */
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }

        System.out.println("[싱글스레드] sum : " + sum); // [싱글스레드] sum : 499500
        System.out.println("[싱글스레드] 메인 스레드 종료"); // [싱글스레드] 메인 스레드 종료

        /*
            멀티 스레드 예제
            - 멀티스레드 인 경우 JVM 에서 실행하고 있는 모든 스레드가 종료되어야 어플리케이션이 종료된다
            - 동일한 코드를 실행하는 각 스레드의 종료 시점은 처리 시간 및 OS 의 스케줄링에 의해 결정되므로 매번 다르게 나올 수 있다
              Ex) [멀티스레드] 메인 스레드 종료
                  [멀티스레드] Thread-0: 스레드 실행 중...
                  [멀티스레드] Thread-1: 스레드 실행 중...
                  [멀티스레드] Thread-2: 스레드 실행 중...
         */
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MyRunnable2(i));
            thread.start();
        }

        System.out.println("[멀티스레드] 메인 스레드 종료");
    }
}

class MyRunnable2 implements Runnable {

    private final int threadId;

    public MyRunnable2(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println("[멀티스레드] " + Thread.currentThread().getName() + ": 스레드 실행 중...");
    }

}