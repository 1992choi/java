package inflearn.concurrency.section03;

public class Ex01 {

    public static void main(String[] args) {
        /*
            방법 1. Thread 를 상속한 클래스
            - 가장 기본적인 방식이며 Thread 클래스를 반드시 상속받아야 한다
            - 상속의 특성상 컴파일 타임 시점에 실행코드가 결정되어 동적인 기능 변경이 불가능하다는 단점이 있다
         */
        MyThread thread1 = new MyThread();
        thread1.start();

        /*
            방법 2. Thread 익명 클래스
            - 스레드 객체를 참조하거나 재활용하지 않고 일회용으로만 사용할 경우
         */
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :스레드 실행 중..");
            }
        };

        thread2.start();

        /*
            방법 3. Runnable 구현
            - Runnable 을 태스크로 활용하는 방식으로서 선호하는 방식이다
            - 스레드와 실행하고자 하는 태스크를 분리함으로써 좀 더 유연하고 확장 가능한 구조로 구현이 가능하다
         */
        MyRunnable task = new MyRunnable();
        Thread thread3 = new Thread(task);
        thread3.start();

        /*
            방법 4. Runnable 익명 클래스
            - Runnable 을 태스크로 활용하는 방식으로서 선호하는 방식이다
            - 스레드와 실행하고자 하는 태스크를 분리함으로써 좀 더 유연하고 확장 가능한 구조로 구현이 가능하다
         */
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중..");
            }
        });

        thread4.start();

        /*
            방법 5. Runnable 람다 방식
            - Runnable 을 태스크로 활용하는 방식으로서 선호하는 방식이다
            - 스레드와 실행하고자 하는 태스크를 분리함으로써 좀 더 유연하고 확장 가능한 구조로 구현이 가능하다
         */
        MyRunnable task2 = new MyRunnable();
        Thread thread5 = new Thread(task2);
        thread5.start();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :스레드 실행 중.. ");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중");
    }
}