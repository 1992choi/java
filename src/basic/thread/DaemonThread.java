package basic.thread;

public class DaemonThread {

    public static void main(String[] args) {
        /*
            사용자 스레드와 데몬 스레드
            - 사용자 스레드는 모두 끝나야 어플리케이션이 종료된다.
            - 반면, 데몬 스레드는 끝나지 않았어도 어플리케이션이 종료되며 데몬 스레드도 자동으로 종료된다.
         */

        // 사용자 스레드 예제
//        Thread userThread1 = new Thread(() -> {
//            for (int i = 0; i < 3; i++) {
//                System.out.println("사용자 스레드 1 실행 중...");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("사용자 스레드 1 종료.");
//        });
//
//        Thread userThread2 = new Thread(() -> {
//            for (int i = 0; i < 2; i++) {
//                System.out.println("사용자 스레드 2 실행 중...");
//                try {
//                    Thread.sleep(1500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("사용자 스레드 2 종료.");
//        });
//
//        userThread1.start();
//        userThread2.start();
//
//        System.out.println("메인 스레드 종료");


        // 데몬 스레드 예제 - 데몬스레드는 무한 반복이라 끝나지 않지만 유저스레드가 끝나는 동시에 어플리케이션이 종료되며 데몬 스레드도 자동 종료된다.
        Thread userThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("사용자 스레드 실행 중..");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    System.out.println("데몬 스레드 실행 중..");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("메인 스레드 종료");
    }

}
