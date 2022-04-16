package basic.clazz;

abstract class Calc {
    public abstract int sum(int a, int b);
}

class MyCalc extends Calc {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}

public class AnonymousClassEx {

    public static void main(String[] args) {

        // 추상클래스를 상속받은 MyCalc 클래스로 구현
        MyCalc myCalc = new MyCalc();
        System.out.println(myCalc.sum(3, 4)); // 7


        // MyCalc 클래스를 사용하지 않고 익명 클래스를 통한 구현
        Calc anonymousCalc = new Calc() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        System.out.println(anonymousCalc.sum(1, 5)); // 6

    }

}
