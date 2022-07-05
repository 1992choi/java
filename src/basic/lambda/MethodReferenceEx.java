package basic.lambda;


import java.util.function.Function;

public class MethodReferenceEx {

    public static void main(String[] args) {
        /*
            메서드 참조는 람다 표현식이 단 하나의 메서드만을 호출하는 경우에
            해당 람다 표현식에서 불필요한 매개변수를 제거하고 사용할 수 있도록 해준다.
         */

        // 람다 표현식
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        int num1 = f1.apply("007");
        System.out.println(num1); // 7

        // 메서드 참조
        Function<String, Integer> f2 = Integer::parseInt;
        int num2 = f2.apply("008");
        System.out.println(num2); // 8
    }

}
