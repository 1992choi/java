package basic.thread;

class Storage {

    public String nameStore;

    public void save(String name) {
        nameStore = name;
        sleep(2000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadLocalStorage {

    public ThreadLocal<String> nameStore = new ThreadLocal<>();

    public void save(String name) {
        nameStore.set(name);
        sleep(2000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLocalEx {

    public static void main(String[] args) {
        /* ThreadLocal을 사용하지 않은 경우 */
        System.out.println("*** ThreadLocal을 사용하지 않은 경우 ***");
        Storage storage = new Storage();
        new Thread(() -> {
            System.out.println("저장할 값 : 홍길동");
            storage.save("홍길동");
            System.out.println("저장된 값 : " + storage.nameStore);
        }).start();

        new Thread(() -> {
            System.out.println("저장할 값 : 김자바");
            storage.save("김자바");
            System.out.println("저장된 값 : " + storage.nameStore);
        }).start();

        /*
            * 실행결과
            *** ThreadLocal을 사용하지 않은 경우 ***
            저장할 값 : 홍길동
            저장할 값 : 김자바
            저장된 값 : 김자바 // 홍길동을 저장 후 -> 저장된 값을 가져오기 -> 홍길동 반환x : 저장된 값을 가져오기 직전에 김자바라는 이름이 저장되어 예상과는 다른 '김자바' 값이 반환된다.
            저장된 값 : 김자바
         */



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        /* ThreadLocal을 사용한 경우 */
        System.out.println("*** ThreadLocal을 사용한 경우 ***");
        ThreadLocalStorage threadLocalStorage = new ThreadLocalStorage();
        new Thread(() -> {
            System.out.println("저장할 값 : 홍길동");
            threadLocalStorage.save("홍길동");
            System.out.println("저장된 값 : " + threadLocalStorage.nameStore.get());
        }).start();

        new Thread(() -> {
            System.out.println("저장할 값 : 김자바");
            threadLocalStorage.save("김자바");
            System.out.println("저장된 값 : " + threadLocalStorage.nameStore.get());
        }).start();

        /*
            * 실행결과
            *** ThreadLocal을 사용한 경우 ***
            저장할 값 : 홍길동
            저장할 값 : 김자바
            저장된 값 : 홍길동 // ThreadLocal을 사용하지 않은 결과와 반대로 정상적인 값을 반환한다.
            저장된 값 : 김자바


            * 주의사항
            - 쓰레드풀 환경에서는 ThreadLocal을 사용 후 보관된 데이터를 반드시 삭제해주어야 한다.
              그렇지 않을 경우, 재사용되는 쓰레드가 이전에 생성된 데이터를 참조할 수 있다.
         */
    }

}
