package basic.thread;

class InheritableThreadLocalEx {

    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        /*
            InheritableThreadLocal
            - InheritableThreadLocal은 ThreadLocal의 확장 버전으로서 부모 스레드로부터 자식 스레드로 값을 전달하고 싶을 경우 InheritableThreadLocal을 사용할 수 있다
            - 값의 상속
              - 부모 스레드가 InheritableThreadLocal 변수에 값을 설정하면, 해당 부모 스레드로부터 생성된 자식 스레드들은 부모의 값을 상속받게 된다
            - 독립성
              - 자식 스레드가 상속받은 값을 변경하더라도 부모 스레드의 값에는 영향을 주지 않는다
         */

        inheritableThreadLocal.set("부모 스레드의 값");

        Thread childThread = new Thread(() -> {
            // 부모 스레드로부터 값 상속
            System.out.println("자식 스레드에서 상속받은 값: " + inheritableThreadLocal.get()); // 자식 스레드에서 상속받은 값: 부모 스레드의 값

            // 자식 스레드에서 값을 변경
            inheritableThreadLocal.set("자식 스레드의 새로운 값");
            System.out.println("자식 스레드에서 설정한 후의 값: " + inheritableThreadLocal.get()); // 자식 스레드에서 설정한 후의 값: 자식 스레드의 새로운 값
        });

        childThread.start();

        // 자식 스레드가 종료될 것을 기다립니다.
        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 부모 스레드의 값 확인
        System.out.println("부모 스레드의 값: " + inheritableThreadLocal.get()); // 부모 스레드의 값: 부모 스레드의 값 (위에서 자식스레드가 값을 변경하였지만, 부모 스레드는 영향을 받지 않는다.)
    }

}