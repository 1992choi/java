package fastcampus.stream.part5;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex01 {

    public static void main(String[] args) {
        // 예제 1. 클래스의 static method를 사용하는 방법 = Integer::parseInt
        Function<String, Integer> str2int = Integer::parseInt;
        System.out.println(str2int.apply("20")); // 20

        // 예제 2. 인스턴스의 method를 사용하는 방법 = str::equals
        String str = "hello";
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("world")); // false

        // 예제 3. 함수를 직접 넘기는 방식
        System.out.println(calculate(8, 2, (x, y) -> x + y));

        // 예제 4. 클래스의 static method를 사용하는 방법 = Ex01::multiply
        System.out.println(calculate(8, 2, Ex01::multiply));

        // 예제 5. 인스턴스의 method를 사용하는 방법 = instance::subtract
        Ex01 instance = new Ex01();
        System.out.println(calculate(8, 2, instance::subtract));

        // 예제 6. 메서드 안에서 다른 메서드를 지정하는 방법 = this::subtract
        instance.myMethod();
    }

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public void myMethod() {
        System.out.println(calculate(10, 3, this::subtract));
    }

}
