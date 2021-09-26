package basic.interfaces;

interface AA {

    /*
        자바 8에서는 인터페이스에 정적 메서드가 추가되었다.
        정적 메서드가 추가됨에 따라 인터페이스를 구현한 클래스없이 바로 호출이 가능하게 되었다.
     */
    static void staticMethod() {
        System.out.println("staticMethod() 호출");
    }
}

public class StaticMethod {

    public static void main(String[] args) {
        AA.staticMethod(); // staticMethod() 호출
    }

}
