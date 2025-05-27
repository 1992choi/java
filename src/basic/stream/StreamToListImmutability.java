package basic.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToListImmutability {

    public static void main(String[] args) {
        /*
            Java Stream API를 사용하여 생성한 리스트의 불변성과 가변성을 비교
            - toList()
              - 불변 리스트(immutable list)를 반환
              - UnsupportedOperationException을 발생
            - java.util.stream.Collectors.toList()
              - 가변 리스트(mutable list)를 반환
              - 정상적으로 요소 추가
         */
        List<String> immutableList = Stream.of("a", "b", "c").toList();
        try {
            immutableList.add("d");
        } catch (UnsupportedOperationException ignored) {
        }
        System.out.println("immutableList = " + immutableList); // immutableList = [a, b, c]

        List<String> mutableList = Stream.of("a", "b", "c").collect(Collectors.toList());
        mutableList.add("d");
        System.out.println("mutableList = " + mutableList); // mutableList = [a, b, c, d]
    }

}
