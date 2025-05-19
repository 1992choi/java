package basic.thread;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        Thread.sleep(100);

        thread.interrupt();
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            /*
                isInterrupted()와 interrupted() 차이
                - 자바에서 isInterrupted()와 interrupted()는 스레드의 인터럽트 상태를 확인할 때 사용되지만, 동작 방식에 차이가 있다.

                isInterrupted()
                - 인터럽트 상태를 초기화하지 않음
                - 즉, 인터럽트 상태가 true면 계속 true 반환

                interrupted()
                - 확인 후 인터럽트 상태를 초기화함
                - 즉, 한 번 호출하면 상태가 false로 바뀜
             */

            /*
                isInterrupted() 사용
                - 상태를 초기화하지 않기 때문에 이후 코드인 자원정리 중 발생하는 sleep를 만나는 순간 예외가 발생하여 의도와 다르게 동작한다. (=자원을 정상적으로 해제하지 못함)
             */
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("작업 중");
//            }
//
//            try {
//                System.out.println("작업 후 자원 정리");
//                Thread.sleep(1000);
//                System.out.println("작업 후 자원 정리 - 완료");
//            } catch (InterruptedException e) {
//                System.out.println("작업 후 자원 정리 - 실패");
//            }

            /*
                interrupted() 사용
                - 상태를 초기화하기 때문에 인터럽트 상태가 다시 정상(=false)로 돌아오기 때문에 이후 자원 정리도 정상 수행된다.
             */
            while (!Thread.interrupted()) {
                System.out.println("작업 중");
            }

            try {
                System.out.println("작업 후 자원 정리");
                Thread.sleep(1000);
                System.out.println("작업 후 자원 정리 - 완료");
            } catch (InterruptedException e) {
                System.out.println("작업 후 자원 정리 - 실패");
            }
        }
    }

}
