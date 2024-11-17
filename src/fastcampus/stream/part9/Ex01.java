package fastcampus.stream.part9;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex01 {

    public static void main(String[] args) {
        /*
            Closer
            - 내부 함수가 존재하는 한 내부 함수가 사용한 외부 함수의 변수들 역시 계속 존재한다.
              이렇게 lexical scope를 포함하는 함수를 closer라고 한다.
            - 이 때 내부 함수가 사용한 외부 함수의 변수들은 내부 함수 선언 당시로부터 변할 수 없기 때문에 final로 선언되지 않더라도 암묵적으로 final로 취급한다.

            Curry
            - 여러 개의 매개변수를 받는 함수를 중첩된 여러 개의 함수로 쪼개어,
              매개 변수를 한 번에 받지 않고 여러 단계에 걸쳐 받는 기술
         */

        // 예제 1. Closer - getStringSupplier() 내부의 hello 변수는 getStringSupplier()가 수행이 종료되도 사라지지 않는다. 이후에 supplier.get()에서 사용되기 때문.
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get()); // HelloWorld

        // 예제 2. Curry
        // x + y를 한 번에 받아와 더하는 방식.
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        // y를 필요할 때 받아와 x + y를 하는 방식(=Curry).
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;
        Function<Integer, Integer> addThree = curriedAdd.apply(3);
        int result = addThree.apply(10);
        System.out.println(result); // 13
    }

    public static Supplier<String> getStringSupplier() {
        String hello = "Hello";
        Supplier<String> supplier = () -> {
            String world = "World";
            return hello + world;
        };

        return supplier;
    }

}
