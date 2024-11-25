package inflearn.concurrency.section4;

public class Ex02 {

    public static void main(String[] args) throws Exception {
        /*
            join()
            • join() 메서드는 한 스레드가 다른 스레드가 종료될 때까지 실행을 중지하고 대기상태에 들어갔다가
              스레드가 종료되면 실행대기 상태로 전환된다
            • 스레드의 순서를 제어하거나 다른 스레드의 작업을 기다려야 하거나 순차적인 흐름을 구성하고자 할 때 사용할 수 있다
            • Object 클래스의 wait() 네이티브 메서드로 연결되며 시스템 콜을 통해 커널모드로 수행한다.
            • 내부적으로 wait() & notify() 흐름을 가지고 제어한다

            작동 방식
            • join() 을 실행하면 OS 스케줄러는 join() 을 호출한 스레드를 대기 상태로 전환하고 호출 대상 스레드에게 CPU 를 사용하도록 한다
            • 호출 대상 스레드의 작업이 종료되면 join() 을 호출한 스레드는 실행 대기 상태로 전환 되고 CPU 가 실행을 재개할 때 까지 기다린다.
            • join() 을 호출한 스레드가 실행 대기에서 실행 상태가 되면 그 스레드는 남은 지점부터 실행을 다시 시작한다
            • 호출 대상 스레드가 여러 개일 경우 각 스레드의 작업이 종료될 때 까지 join() 을 호출한 스레드는 대기와 실행을 재개하는 흐름을 반복한다
            • join() 을 호출한 스레드가 인터럽트 되면 해당 스레드는 대기에서 해제되고 실행상태로 전환되어 예외를 처리하게 된다
        */

        /*
            예제 1. 기본 join
            - 메인 스레드가 thread의 작업 완료를 기다린다.
            - 실행결과
                메인 스레드가 다른 스레드의 완료를 기다립니다.
                스레드가 3초 동안 작동합니다.
                스레드 작동 완료.
                메인 스레드가 계속 진행합니다
         */
//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println("스레드가 3초 동안 작동합니다.");
//                Thread.sleep(5000);
//                System.out.println("스레드 작동 완료.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        thread.start();
//
//        System.out.println("메인 스레드가 다른 스레드의 완료를 기다립니다.");
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("메인 스레드가 계속 진행합니다");



        /*
            예제 2. 멀티스레드의 join
            - 메인 스레드가 thread1과 thread2의 작업 완료를 기다린다.
            - 실행결과
                메인 스레드가 다른 스레드의 완료를 기다립니다.
                스레드 1이 3초 동안 작동합니다.
                스레드 2가 2초 동안 작동합니다.
                스레드 2 작동 완료.
                스레드 1 작동 완료.
                메인 스레드가 계속 진행합니다
         */
//        Thread thread1 = new Thread(() -> {
//            try {
//                System.out.println("스레드 1이 3초 동안 작동합니다.");
//                Thread.sleep(3000);
//                System.out.println("스레드 1 작동 완료.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            try {
//                System.out.println("스레드 2가 2초 동안 작동합니다.");
//                Thread.sleep(2000);
//                System.out.println("스레드 2 작동 완료.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("메인 스레드가 다른 스레드의 완료를 기다립니다.");
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println("메인 스레드가 계속 진행합니다");



        /*
            예제 3. Interrupt
            - 메인 스레드는 longRunningThread에 join되어 있는 상태라서,
              longRunningThread가 완료되어야지 메인 스레드 수행된다.
            - 이 때, interruptingThread에 의해서 longRunningThread는 interrupt가 발생한다.
              - interrupt로 인하여 longRunningThread는 catch문이 수행되고, 여기서 다시 mainThread에게 interrupt가 발생한다.
                - interrupt를 받은 mainThread는 waiting상태에서 깨어나서 Runnable 상태가 되지만, 작업을 실행할 수 있는 상태가 아니라 InterruptedException이 발생한다.
            - 실행결과
                긴 작업 스레드가 계속 실행 중...
                인터럽트 스레드가 2초 후에 긴 작업 스레드를 인터럽트 합니다.
                메인 스레드가 긴 작업 스레드의 완료를 기다립니다.
                긴 작업 스레드가 계속 실행 중...
                긴 작업 스레드가 인터럽트 되었습니다.
                메인 스레드가 인터럽트 되었습니다.
         */
        Thread mainThread = Thread.currentThread();

        Thread longRunningThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("긴 작업 스레드가 계속 실행 중...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                mainThread.interrupt();
                System.out.println("긴 작업 스레드가 인터럽트 되었습니다.");
            }
        });

        longRunningThread.start();

        Thread interruptingThread = new Thread(() -> {
            try {
                System.out.println("인터럽트 스레드가 2초 후에 긴 작업 스레드를 인터럽트 합니다.");
                Thread.sleep(2000);
                longRunningThread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        interruptingThread.start();

        try {
            System.out.println("메인 스레드가 긴 작업 스레드의 완료를 기다립니다.");
            longRunningThread.join();
            System.out.println("메인 스레드 작업 완료");

        } catch (InterruptedException e) {
            System.out.println("메인 스레드가 인터럽트 되었습니다.");
            throw new RuntimeException(e);
        }
    }

}
