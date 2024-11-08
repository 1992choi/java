package fastcampus.stream.part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerEx {

    public static void main(String[] args) {
        /*
            BiConsumer
            - 소비자
            - 2개의 input만 받아 처리한다.
            - return 값은 존재하지 않는다.
         */

        // 예제 1. 2개의 input을 받아 출력만 해주는 함수
        BiConsumer<Integer, Double> myDoubleProcessor =
                (index, input) -> System.out.println("Processing " + input + " at index " + index);
        List<Double> inputs = Arrays.asList(1.1, 2.2, 3.3);
        process(inputs, myDoubleProcessor); // input 값과 인덱스를 출력해준다.
    }

    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor) {
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }

}
