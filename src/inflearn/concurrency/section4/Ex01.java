package inflearn.concurrency.section4;

public class Ex01 {

    public static void main(String[] args) throws Exception {
        /*
            sleep()
            • sleep() 메서드는 지정된 시간 동안 현재 스레드의 실행을 일시 정지하고 대기상태로 빠졌다가 시간이 지나면 실행대기 상태로 전환된다.

            sleep() 작동 방식
            • sleep() 이 되면 OS 스케줄러는 현재 스레드를 지정된 시간 동안 대기 상태로 전환하고 다른 스레드 혹은 프로세스에게 CPU 를 사용하도록 한다
            • 대기 시간이 끝나면 스레드 상태는 바로 실행상태가 아닌 실행 대기 상태로 전환 되고 CPU 가 실행을 재개할 때 까지 기다린다.
            • 실행 상태가 되면 스레드는 남은 지점부터 실행을 다시 시작한다
            • 동기화 메서드 영역에서 수면 중인 스레드는 획득한 모니터나 락을 잃지 않고 계속 유지한다
            • sleep() 중인 스레드에게 인터럽트가 발생할 경우 현재 스레드는 대기에서 해제되고 실행상태로 전환되어 예외를 처리하게 된다
            • 스레드의 수면 시간은 OS 스케줄러 및 시스템 기능에 따라 제한되기 때문에 정확성이 보장되지 않으며 시스템의 부하가 많고 적음에 따라 지정한 수면 시간과 차이가 날 수 있다

            sleep(0)과 sleep(n) 의 의미
            • sleep(0)
                • 스레드가 커널 모드로 전환 후 스케줄러는 현재 스레드와 동일한 우선순위(Priority)의 스레드가 있을 경우 실행대기상태 스레드에게 CPU 를 할당함으로 컨텍스트 스위칭이 발생한다
                • 만약 우선순위가 동일한 실행대기 상태의 다른 스레드가 없으면 스케줄러는 현재 스레드에게 계속 CPU 를 할당해서 컨텍스트 스위칭이 없고 모드 전환만 일어난다
            • sleep(n)
                • 스레드가 커널 모드로 전환 후 스케줄러는 조건에 상관없이 현재 스레드를 대기상태에 두고 다른 스레드에게 CPU 를 할당함으로 모든 전환과 함께 컨텍스트 스위칭이 발생한다
         */

        /*
            예제 1. 기본 sleep
            - 2초 후(=2초 sleep)에 Hello World 메시지가 출력된다.
         */
        try {
            System.out.println("2초 후에 메시지가 출력됩니다");
            Thread.sleep(2000);
            System.out.println("Hello World");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
            예제 2. 슬립 반복
            - 메시지 출력 후 1초마다 슬립.
         */
        for (int i = 0; i < 7; i++) {
            try {
                System.out.println("반복: " + (i + 1));
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /*
            예제 3. 멀티스레드 슬립
            - 출력결과
                여기는 메인입니다.
                2초 후에 메시지가 출력됩니다 (이 부분은 바로 밑 메시지와 순서가 바뀔 수 있다.)
                1초 후에 메시지가 출력됩니다 (이 부분은 바로 위 메시지와 순서가 바뀔 수 있다.)
                스레드 1이 깨어났습니다.
                스레드 2가 깨어났습니다.

         */
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("1초 후에 메시지가 출력됩니다");
                Thread.sleep(1000);
                System.out.println("스레드 1이 깨어났습니다.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("2초 후에 메시지가 출력됩니다");
                Thread.sleep(2000);
                System.out.println("스레드 2가 깨어났습니다.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("여기는 메인입니다.");

        /*
            예제 4. Interrupt
            - sleepingThread가 20초 동안 sleep에 들어간 후, 정상적인 케이스라면 20초 후 '인터럽트 없이 잠에서 깨었습니다.' 메시지가 출력되야 한다.
            - 하지만 메인 스레드에서 sleepingThread에 interrupt하여 sleepingThread는 sleep에서 깬 후 바로 InterruptedException이 발생한다.
         */
        Thread sleepingThread = new Thread(() -> {
            try {
                System.out.println("20초 동안 잠듭니다. 인터럽트되지 않는다면 계속 잠들어 있을 것입니다.");

                Thread.sleep(20000); // 스레드는 지정된 시간 동안 잠듭니다

                System.out.println("인터럽트 없이 잠에서 깨었습니다.");

            } catch (InterruptedException e) {
                System.out.println("잠들어 있는 동안 인터럽트 되었습니다!");
            }
        });

        sleepingThread.start();

        Thread.sleep(1000);

        sleepingThread.interrupt();
    }

}
