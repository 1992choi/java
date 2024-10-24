package basic.exception;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ClassImplementsCloseable implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("Call ClassImplementsCloseable");
    }
}

class ClassNotImplementsCloseable {
}

class ClassHavingCustomClose {
    public void close() throws IOException {
        System.out.println("Call ClassHavingCustomClose");
    }
}

public class TryWithResources {

    public static void main(String[] args) {
        /* Try-with-resources 구문은 Closeable 인터페이스를 구현한 클래스만 가능하다. */
        // 1. Closeable 인터페이스를 구현한 클래스
        try (ClassImplementsCloseable class1 = new ClassImplementsCloseable()) {

        } catch (Exception e) {

        }

        // 2. Closeable 인터페이스를 구현하지 않은 클래스 : 오류 발생
//        try (ClassNotImplementsCloseable class2 = new ClassNotImplementsCloseable()) {
//
//        } catch (Exception e) {
//
//        }

        // 3. Closeable 인터페이스를 구현하지 않은 클래스(이름이 동일한 close 메서드만 있는 클래스) : 오류 발생
//        try (ClassHavingCustomClose class3 = new ClassHavingCustomClose()) {
//
//        } catch (Exception e) {
//
//        }



        /* 자원 해제방식 비교 */
        // 기본적인 자원 해제 방식
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("file.txt");
            fos = new FileOutputStream("file.txt");
        } catch (IOException e) {
            // ...
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // ...
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // ...
                }
            }
        }

        // Try-with-resources를 통한 자원 해제
        try (FileInputStream fis2 = new FileInputStream("file.txt");
             FileOutputStream fos2 = new FileOutputStream("file.txt")) {
            // ...
        } catch (IOException e) {
            // ...
        } finally {
            // close()를 명시적으로 호출해줄 필요가 없음.
        }

        /*
            Try-with-resources를 통한 자원 해제의 장점
            - 리소스 누수 방지
              - 실수로 finally를 작성하지 않는 실수를 막아준다.
            - 가독성 향상
              - close()가 없어 코드가 더 간결하고 읽기 쉬워진다.
            - 스코프 범위 한정
              - 리소스로 사용되는 변수의 스코프가 try로만 한정되어 코드 유지보수가 더 쉬워진다.
            - 조금 더 빠른 자원해제
              - 기존 방식 : catch 이후 자원 반납
              - Try-with-resources : try 블럭이 끝남과 동시에 반납 후 catch 구문 실행
         */
    }

}
