package basic.thread;

public class ThreadErrorHandling {

    public static void main(String[] args) {
        /*
            스레드 예외 핸들링
            - 스레드는 단순하게 try ~ catch로 잡을 수 없다.
              아래와 같이 catch에서 잡히길 의도한다면, 잘못된 코드를 생성한 것이다.
         */
        try {
            new Thread(() -> {
                throw new RuntimeException("스레드 예외!");
            }).start();
        } catch (Exception e) {
            System.out.println("스레드 예외 Catch"); // 해당 구문 실행되지 않음.
        }



        /*
            모든 스레드의 예외에 대한 기본 핸들러 설정
            - Thread.setDefaultUncaughtExceptionHandler()을 사용하면 모든 스레드에 대한 예외를 핸들링할 수 있다.
            - thread1과 thread2가 실행 도중 예외가 발생하면, uncaughtException()가 실행된다.
         */
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " 에서 예외 발생 " + e);
            }
        });

        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("스레드 1 예외!");
        });

        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("스레드 2 예외!");
        });

        thread1.start();
        thread2.start();



        /*
            특정 스레드 핸들러
            - setUncaughtExceptionHandler()을 사용하면, 특정 스레드만 핸들링 할 수 있다.
            - 위에서 알아본 Thread.setDefaultUncaughtExceptionHandler()과 같이 사용할 경우,
              setUncaughtExceptionHandler()가 우선 순위가 더 높다.
         */
        Thread thread3 = new Thread(() -> {
            throw new RuntimeException("스레드 3 예외!");
        });

        thread3.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("특정 스레드 예외 설정");
        });

        thread3.start();
    }

}
