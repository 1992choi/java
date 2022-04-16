package basic.interfaces;

@java.lang.FunctionalInterface
interface FunctionalInterface {
    /*
        * 함수형 인터페이스
        : 함수형 인터페이스란 한 개의 추상 메서드로 이루어진 인터페이스를 지칭한다.
            - @FunctionalInterface를 사용하여 명시해준다.
            - 하나의 추상메서드는 선언할 수 있다.(두 개 이상 작성 시, 오류 발생)
            - default, static 메서드는 사용 가능하다.
    */

    void methodA();

    // void methodB(); // 주석해제할 경우 오류발생

    default void defaultMethod() {}

    static void staticMethod() {}
}

public class FunctionalInterfaceEx {

    public static void main(String[] args) {

    }

}
