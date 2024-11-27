package inflearn.concurrency.section4;

public class Ex03 {

    public static void main(String[] args) throws Exception {
        /*
            interrupt()
            • interrupt() 는 스레드에게 인터럽트가 발생했다는 신호를 보내는 메커니즘이다
            • interrupt() 는 스레드가 현재 실행 흐름을 멈추고 인터럽트 이벤트를 먼저 처리하도록 시그널을 보내는 장치라 할 수 있다
            • interrupted 속성
                • 스레드는 인터럽트 상태(Interrupt State)로 알려진 interrupted 를 가지고 있으며 인터럽트 발생 여부를 확인할 수 있는 상태 값이다. 기본값은 fasle 이다
                • 인터럽트된 스레드가 처리해야 하는 특별한 규칙이나 정해진 기준은 없으나 일반적으로 인터럽트 상태를 사용해서 스레드를 중지하거나, 작업을 취소하거나, 스레드를 종료 하는 등의 기능을 구현할 수 있다
                • 한 스레드가 다른 스레드를 인터럽트 할 수 있고 자기 자신을 인터럽트 할 수도 있다
                • interrupt() 하는 횟수는 제한이 없으며 인터럽트 할 때 마다 스레드의 인터럽트 상태를 true 로 변경한다

            static boolean interrupted()
            • 스레드의 인터럽트 상태를 반환하는 정적 메소드이다
            • 만약 현재 인터럽트 상태가 true 인 경우 true 를 반환하고 인터럽트 상태를 false 로 초기화 하므로 인터럽트를 해제하는 역할을 한다

            boolean isInterrupted()
            • 스레드의 인터럽트 상태를 반환하는 인스턴스 메서드이다
            • 이 메서드는 스레드의 인터럽트 상태를 변경하지 않고 계속 유지한다.
            • 인터럽트 상태를 확인하는 용도로만 사용할 경우 interrupted() 보다 이 메서드를 사용하는 것이 좋다

            InterruptedException
            • InterruptedException 은 interrupt() 메카니즘의 일부이며 대기나 차단 등 블록킹 상태에 있거나 블록킹 상태를 만나는 시점의 스레드에 인터럽트 할 때 발생하는 예외이다
            • InterruptedException 이 발생하면 인터럽트 상태는 자동으로 초기화 된다. 즉 Thread.interrupted() 한 것과 같은 상태로 된다( interrupted = false)
            • 다른 곳에서 인터럽트 상태를 참조하고 있다면 예외 구문에서 대상 스레드에 다시 interrupt() 해야 할 수도 있다
        */

        /*
            예제 1. interrupt 기본
            - 스레드1과 스레드2가 실행된 후, 스레드2가 스레드1을 인터럽트한다.
            - isInterrupted()을 사용하여 인터럽트 상태를 보면
              - thread1는 인터럽트 걸렸으므로 true
              - thread2는 인터럽트가 걸리지 않았으므로 false를 반환한다.
            - 실행결과
                스레드 2가 스레드 1을 인터럽트 합니다.
                스레드 2 인터럽트 상태: false
                스레드 1 작업 시작...
                스레드 1 인터럽트 상태: true
                모든 스레드 작업 완료
         */
//        Thread thread1 = new Thread(() -> {
//            System.out.println("스레드 1 작업 시작...");
//            System.out.println("스레드 1 인터럽트 상태: " + Thread.currentThread().isInterrupted());
//        });
//
//        Thread thread2 = new Thread(() -> {
//            System.out.println("스레드 2가 스레드 1을 인터럽트 합니다.");
//            thread1.interrupt(); // 스레드 2가 스레드 1을 인터럽트
//            System.out.println("스레드 2 인터럽트 상태: " + Thread.currentThread().isInterrupted());
//        });
//
//        thread2.start();
//        Thread.sleep(1000);
//        thread1.start();
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println("모든 스레드 작업 완료");


        /*
            예제 2. isInterrupted() 예제
            - 스레드가 시작하면 처음에는 isInterrupted() 값이 false이다.
              때문에 while 조건식에서 !false -> true여서 계속 반복문을 돌다가 thread.interrupt()로 인하여
              인터럽트가 걸리면 isInterrupted()가 true가 되어 while문을 빠져나오게 된다.
            - 실행결과
              스레드가 작동 중입니다.
              스레드가 작동 중입니다.
              ...
              스레드가 작동 중입니다.
              스레드가 인터럽트 되었습니다.
              인터럽트 상태: true
         */
//        Thread thread = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("스레드가 작동 중입니다.");
//            }
//            System.out.println("스레드가 인터럽트 되었습니다.");
//            System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
//        });
//        thread.start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread.interrupt();


        /*
            예제 3. interrupted() 예제
            - 스레드가 시작하면 처음에는 interrupted() 값이 false이다.
              때문에 while 조건식에서 !false -> true여서 계속 반복문을 돌다가 thread.interrupt()로 인하여
              인터럽트가 걸리면 interrupted()가 true가 되어 while문을 빠져나오게 된다.
              예제 2번과 다른점은 interrupted()가 true가 되어 빠져나오는 시점에 interrupted를 false로 초기화를 한다.
            - 실행결과
              스레드가 작동 중입니다.
              스레드가 작동 중입니다.
              ...
              스레드가 작동 중입니다.
              스레드가 인터럽트 되었습니다.
              인터럽트 상태: false (예제 2번과 다른점)
         */
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("스레드가 작동 중입니다.");
            }
            System.out.println("스레드가 인터럽트 되었습니다.");
            System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        });
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }

}
