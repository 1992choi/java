package basic.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveType {

    public static void main(String[] args) {
        /*
            - 기본형을 제공하는 스트림
              : 스트림 API 는 데이터가 객체라는 것을 기본 전제로 설계되어있다.
                따라서 int, long, double 등의 값을 처리하게 되면
                내부적으로 오토박싱과 언박싱이 빈번하게 발생하여 성능 저하를 일으킨다.

            - 기본형으로 많이 사용되는 스트림 종류
              : DoubleStream
              : IntStream
              : LongStream
        */

        // 일반 스트림
        Stream stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream.count()); // 5
        // sum(), max() 등 미제공 : 숫자형 타입의 객체라는 보장이 없으므로...


        // IntStream : 숫자 관련 메서드는 일반 스트림보다 더 많은 기능을 제공한다.
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(intStream.count()); // 5

        intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(intStream.sum()); // 15

        intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(intStream.max().getAsInt()); // 5
    }

}
