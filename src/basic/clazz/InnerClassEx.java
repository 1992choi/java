package basic.clazz;

class Outer {
    int a = 1;
    int b = 2;

    class Inner {
        int c = 3;

        void innerMethod() {
            System.out.println(a); // 객체 생성없이 외부 클래스의 멤버에 접근가능
        }
    }
}

public class InnerClassEx {

    public static void main(String[] args) {
        // 직접 접근 불가 - 내부클래스는 외부클래스를 먼저 생성한 후 생성할 수 있다.
        // Inner inner = new Inner();

        // 외부클래스 생성 후 접근
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.innerMethod();
    }

}
