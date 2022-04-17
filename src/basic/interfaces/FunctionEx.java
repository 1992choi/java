package basic.interfaces;

import java.util.function.Function;

// Function은 Type T 인자를 받아서 Type R을 리턴(입력된 데이터를 변환할 때 사용)하는 함수형 인터페이스의 한 종류이다.
public class FunctionEx {

    public static void main(String[] args) {
        Function<String, String> upperFunction = v -> v.toUpperCase();
        String result = upperFunction.apply("abc");
        System.out.println(result); // ABC

        /* compose()와 andThen()
            * 차이점 : 실행순서의 차이가 있다.
            - compose
                : A.compose(B);
                : B실행 -> A실행

            - andThen
                : A.andThen(B);
                : A실행 -> B실행
         */
        System.out.println(upperFunction.compose(s -> "abc" + s).apply("d")); // ABCD
        System.out.println(upperFunction.andThen(s -> "abc" + s).apply("d")); // abcD
    }

}
