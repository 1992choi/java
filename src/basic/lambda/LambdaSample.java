package basic.lambda;

interface SquareIF {
    int square(int num);
}

public class LambdaSample {

    public static void main(String[] args) {

        /*
         *  추상 메서드를 하나만 갖는 인터페이스를 자바 8부터는 함수형 인터페이스라고 하며,
         *  이런 함수형 인터페이스만을 람다식으로 표현 가능하다.
         */
        SquareIF sif1 = (int a) -> {
            return a * a;
        };
        System.out.println(sif1.square(1)); // 1


        /*
         *  1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있다.
         *     - Square(int num)를 통해 a가 int일 수 밖에 없으므로 int를 생략할 수 있다.
         *     - (int a)가 (a)로 변경되었다.
         */
        SquareIF sif2 = (a) -> {
            return a * a;
        };
        System.out.println(sif2.square(2)); // 4


        /*
         *  2. 매개변수가 하나인 경우는 소괄호를 생략할 수 있다.
         *     - 1번 규칙에 의해 (a)로 변경되었으며, 매개변수가 1개이기 때문에 소괄호도 생략 가능하여 a가 되었다.
         */
        SquareIF sif3 = a -> {
            return a * a;
        };
        System.out.println(sif3.square(3)); // 9


        /*
         *  3. 함추의 몸체가 하나의 명령문만 있을 경우, 중괄호도 생략가능하다. 단, return구문은 생략해야한다.
         */
        SquareIF sif4 = a -> a * a;
        System.out.println(sif4.square(4)); // 16

    }
}
