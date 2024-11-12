package fastcampus.stream.part8;

import java.util.Optional;
import java.util.stream.Stream;

public class Ex03 {

    public static void main(String[] args) {
        /*
            - findFirst
              : stream 안의 첫 번째 데이터 반환. 비어있다면 Optional 반환

            - findAny
              : stream 안의 만족하는 아무 데이터나 반환. 비어있다면 Optional 반환
              : 순서가 중요하지 않고 Parallel Stream을 사용할 때 최적화할 수 있다.
         */
        Optional<Integer> firstPositiveInteger = Stream.of(3, -3, 2, -5, 6)
                .filter(x -> x < 0)
                .findFirst();
        System.out.println(firstPositiveInteger.get()); // -3


        Optional<Integer> anyNegativeInteger = Stream.of(3, -3, 2, -5, 6)
                .filter(x -> x < 0)
                .findAny();
        System.out.println(anyNegativeInteger.get()); // -5

        Optional<Integer> anyNegativeInteger2 = Stream.of(3, -3, 2, -5, 6)
                .parallel()
                .filter(x -> x < 0)
                .findAny();
        System.out.println(anyNegativeInteger2.get()); // -3 또는 -5 (실행 때마다 결과가 바뀐다.)
    }

}
