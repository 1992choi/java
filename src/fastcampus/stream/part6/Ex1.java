package fastcampus.stream.part6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {

    public static void main(String[] args) {
        // 예제 1. Stream.of()를 사용해서 스트림 만들기
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println(names);

        // 예제 2. Arrays.stream()를 사용해 스트림 만들기
        String[] cityArray = new String[] {"San Jose", "Seoul", "Tokyo" };
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityList = cityStream.collect(Collectors.toList());
        System.out.println(cityList);

        // Collection 프레임워크의 .stream()을 활용해 스트림 만들기
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println(numberList);
    }

}
