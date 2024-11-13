package fastcampus.stream.part8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex05 {

    public static void main(String[] args) {
        // 예제 1. 리스트로 반환
        List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toList());
        System.out.println(numberList); // [3, 5, -3, 3, 4, 5]

        // 예제 2. 셋으로 반환
        Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println(numberSet); // [-3, 3, 4, 5]

        // 예제 3. mapping을 사용하여 절대값으로 변경 후 리스트 반환
        List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println(numberList2); // [3, 5, 3, 3, 4, 5]

        // 예제 4. mapping을 사용하여 절대값으로 변경 후 셋 반환
        Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
        System.out.println(numberSet2); // [3, 4, 5]

        // 예제 5. Collectors의 reducing 사용
        int sum = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println(sum); // 17
    }

}
