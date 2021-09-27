package basic.exception;

class ThrowTest {
    void a() {
        try {
            b();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException 발생");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생");
        }
    }

    void b() throws ArithmeticException, NumberFormatException { // throws 예외 클래스A, 예외 클래스B, 예외 클래스C 형태로 작성 가능
        // 예외가 발생하지만 throws ArithmeticException를 통해 예외 전가
        // int a = 1 / 0;

        // 예외가 발생하지만 throws NumberFormatException 통해 예외 전가
        // int b = Integer.parseInt("b");

        // 예외를 전가하지 않아 시스템 종료 처리
        String c = null;
        c.charAt(0);
    }
}

public class MultiThrows {

    public static void main(String[] args) {
        ThrowTest throwTest = new ThrowTest();
        throwTest.a();
    }

}
