package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperation {

    public static void main(String[] args) {

        /*
            * 중개 연산(Intermediate Operation)
              - 스트림 필터링 : filter(), distinct()
              - 스트림 변환 : map(), flatMap()
              - 스트림 제한 : limit(), skip()
              - 스트림 정렬 : sorted()
              - 스트림 연산 결과 확인 : peek()
         */

        List<String> list = Arrays.asList("java", "java", "c", "c++", "c++", "javascript", "css", "html", "go", "python");
        Stream<String> originStream = null;

        System.out.println("\n\n--- filter ---");
        originStream = list.stream();
        Stream<String> filterStream = originStream.filter(s -> 'c' == s.charAt(0));
        filterStream.forEach(s -> System.out.print(s + " ")); // c c++ c++ css

        System.out.println("\n\n--- distinct ---");
        originStream = list.stream();
        Stream<String> distinctStream = originStream.distinct();
        distinctStream.forEach(s -> System.out.print(s + " ")); // java c c++ javascript css html go python

        System.out.println("\n\n--- map ---");
        originStream = list.stream();
        Stream<String> mapStream = originStream.map(s -> s.toUpperCase());
        mapStream.forEach(s -> System.out.print(s + " ")); // JAVA JAVA C C++ C++ JAVASCRIPT CSS HTML GO PYTHON

        System.out.println("\n\n--- limit ---");
        originStream = list.stream();
        Stream<String> limitStream = originStream.limit(3); // 3개까지 추출
        limitStream.forEach(s -> System.out.print(s + " ")); // java java c

        System.out.println("\n\n--- skip ---");
        originStream = list.stream();
        Stream<String> skipStream = originStream.skip(3); // 3번째까지 생략하고 추출
        skipStream.forEach(s -> System.out.print(s + " ")); // c++ c++ javascript css html go python

        System.out.println("\n\n--- sorted ---");
        originStream = list.stream();
        Stream<String> sortedStream = originStream.sorted();
        sortedStream.forEach(s -> System.out.print(s + " ")); // c c++ c++ css go html java java javascript python

    }

}
