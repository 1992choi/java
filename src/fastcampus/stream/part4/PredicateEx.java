package fastcampus.stream.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateEx {

    public static void main(String[] args) {
        /*
            Predicate
            - 1개의 input만 받아 참/거짓 값을 반환한다.
         */
        // 예제 1. 양수인지 판단
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(-10)); // false

        // 예제 2. Predicate의 조건에 만족하는 값만 반환
        List<Integer> inputs = Arrays.asList(10, -5, 4, -2, 0, 3);

        // 직접 만든 Predicate으로 조건 판단
        System.out.println("Positive number: " + filter(inputs, isPositive)); // Positive number: [10, 4, 3]

        // 직접 만든 Predicate의 반대 조건으로 판단
        System.out.println("Non-positive number: " + filter(inputs, isPositive.negate())); // Non-positive number: [-5, -2, 0]

        // 직접 만든 Predicate으로 조건에 or 조건 추가하여 판단
        System.out.println("Non-negative number: " + filter(inputs, isPositive.or(x -> x == 0))); // Non-negative number: [10, 4, 0, 3]

        // 직접 만든 Predicate으로 조건에 and 조건 추가하여 판단
        System.out.println("Positive even numbers: " + filter(inputs, isPositive.and(x -> x % 2 == 0))); // Positive even numbers: [10, 4]
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }

}
