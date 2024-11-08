package fastcampus.stream.part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

    public static void main(String[] args) {
        /*
            Consumer
            - 소비자
            - input만 받아 처리한다.
            - return 값은 존재하지 않는다.
         */

        // 예제 1. input을 받아 출력만 해주는 함수
        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);
        myStringConsumer.accept("hello"); // hello
        myStringConsumer.accept("world"); // world

        // 예제 2. 다른 실행 함수를 넘기는 예제.
        // process()에 넘기는 함수에 따라 동작 방식을 달리할 수 있다.
        // 예제의 단순화를 위해 출력문구만 변경하였지만 Consumer의 구현로직에 따라 다른 동작을 유도할 수 있다.
        // 제네릭 사용을 통해 확장성을 높일 수 있다.
        List<Integer> integerInputs = Arrays.asList(4, 2, 3);
        Consumer<Integer> myIntegerProcessor = x -> System.out.println("Processing integer " + x);
        process(integerInputs, myIntegerProcessor); // Processing integer ${integerInputs} 출력

        Consumer<Integer> myDifferentIntegerProcessor = x -> System.out.println("Processing integer in different way " + x);
        process(integerInputs, myDifferentIntegerProcessor);  // Processing integer in different way ${integerInputs} 출력

        Consumer<Double> myDoubleProcessor = x -> System.out.println("Processing double " + x);
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        process(doubleInputs, myDoubleProcessor);
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

}
