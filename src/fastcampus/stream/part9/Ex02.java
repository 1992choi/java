package fastcampus.stream.part9;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02 {

    public static void main(String[] args) {
        /*
            Lazy Evaluation
            - 계산을 바로 실행하지 않고, 뒤로 미룸(=필요할 때까지 지연한 후 필요할 때 계산되도록 처리)
         */

        /*
            예제 1. returnTrue()가 실행된 후 true 값을 반환하여, returnFalse()가 실행되지 않는다.
            - 실행결과
              Returning true
              true
         */
        if (returnTrue() || returnFalse()) {
            System.out.println("true");
        }

        /*
            예제 2. returnTrue()가 실행된 후 true 값을 반환하지만, returnFalse()도 실행된다.
                   그 이유는 or연산이 returnTrue()와 returnFalse()가 모두 실행된 후에 수행되기 때문이다.
                   만약 실행되는 메서드가 값 비싼 연산이라면 비효율적인 코드가 되는 것이다.
            - 실행결과
              Returning true
              Returning false
              true
         */
        if (or(returnTrue(), returnFalse())) {
            System.out.println("true");
        }

        /*
            예제 3. Lazy 연산을 통해 returnTrue() 연산결과에 따라 returnFalse()를 수행하지 않을 있게 변경할 수 있다.
            - 실행결과
              Returning true
              true
         */
        if (lazyOr(() -> returnTrue(), () -> returnFalse())) {
            System.out.println("true");
        }

        /*
            예제 4. 스트림에서도 Lazy 연산을 수행한다.
                   실행결과를 보면 알 수 있듯이, 코드로는 아래왁 같은 실행결과를 추측할 수 있겠지만
                   ----------- (예상 출력)
                   peeking + n
                   Before collect
                   After collect: [8, 10]
                   -----------

                   스트림은 종결 연산이 호출되기 전까지 연산을 미루기 때문에 아래와 같은 출력 결과를 확인할 수 있을 것이다.
                   ----------- (살제 출력)
                   Before collect
                   peeking + n
                   After collect: [8, 10]
                   -----------
         */
        Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("peeking " + x))
                .filter(x -> x % 2 == 0);
        System.out.println("Before collect");

        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After collect: " + integers);
    }

    public static boolean or(boolean x, boolean y) {
        return x || y;
    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }

    public static boolean returnTrue() {
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }

}
