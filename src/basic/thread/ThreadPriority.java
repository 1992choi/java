package basic.thread;

public class ThreadPriority {

    public static void main(String[] args) throws InterruptedException {
        /*
            스레드 우선순위 (Priority)
            - Java에서 스레드의 우선 순위는 1에서 10 사이의 정수이며 정수 값이 높을수록 우선순위가 높다
            - 스레드가 생성될 때 우선순위 값이 정해지며 기본 우선 순위인 5 로 설정된다
            - 스케줄러는 우선순위가 높은 스레드를 실행하다가 해당 스레드가 중지, 양보 또는 실행 불가능이 되는 경우 우선 순위가 낮은 스레드를 실행하기 시작한다
            - 두 스레드의 우선순위가 같을 경우 라운드 로빈(순환 할당) 스케줄링 방식에 의해 다음 스레드를 선택한다
            - 스케줄러가 반드시 우선순위가 높은 스레드를 실행한다고 보장 할 수 없다.
              운영체제마다 다른 정책들이 있을 수 있으며 기아상태를 피하기 위해 스케줄러는 우선순위가 낮은 스레드를 선택할 수 있다
         */
        Thread thread = new Thread();
        System.out.println("기본우선순위: " + thread.getPriority()); // 5
        thread.start();

        Thread minThread = new Thread(() -> {
            System.out.println("최소 우선순위 :" + Thread.currentThread().getPriority()); // 1
        });
        minThread.setPriority(Thread.MIN_PRIORITY);
        minThread.start();

        Thread normThread = new Thread(() -> {
            System.out.println("기본 우선순위 :" + Thread.currentThread().getPriority()); // 5
        });
        normThread.setPriority(Thread.NORM_PRIORITY);
        normThread.start();

        Thread maxThread = new Thread(() -> {
            System.out.println("최대 우선순위 :" + Thread.currentThread().getPriority()); // 10
        });
        maxThread.setPriority(Thread.MAX_PRIORITY);
        maxThread.start();

    }

}
