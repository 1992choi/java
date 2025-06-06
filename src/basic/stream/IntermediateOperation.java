package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperation {

    public static void main(String[] args) {

        /*
            * 중개 연산(Intermediate Operation)
              - 스트림 필터링 : filter(), distinct(), takeWhile(), dropWhile()
                - takeWhile(), dropWhile() 는 자바9에서 생긴 기능
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

        System.out.println("\n\n--- flatMap ---");
        /*
            flatMap
            - 스트림의 형태가 배열과 같을 때, 모든 원소를 단일 원소 스트림으로 반환
            - map과의 차이점 : map 메서드는 스트림의 스트림을 반환하는 반면에 flatMap 메서드는 스트림을 반환한다.
                            따라서 출력을 했을 때, 아래와 같은 차이를 지닌다.
         */
        String[][] namesArray = new String[][]{
                {"kim", "choi"}, {"lee", "park"}};

        // map #1
        Arrays.stream(namesArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(s -> System.out.print(s + " ")); // java.util.stream.ReferencePipeline$Head@5caf905d java.util.stream.ReferencePipeline$Head@27716f4

        // map #2
        Arrays.stream(namesArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(names -> names.forEach(s -> System.out.print(s + " "))); // kim choi lee park

        // flatMap
        Arrays.stream(namesArray)
                .flatMap(inner -> Arrays.stream(inner))
                .forEach(s -> System.out.print(s + " ")); // kim choi lee park

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

        System.out.println("\n\n--- peek ---");
        originStream = list.stream();
        Stream<String> peekStream = originStream.sorted();
        peekStream
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println("1. " + s ))
                .distinct()
                .peek(s -> System.out.println("2. " + s))
                .forEach(s -> System.out.println("3. " + s));
        /*
            - peek : 스트림의 요소를 소비하지 않고 확인할 수 있다. (중간에 데이터 처리 과정을 볼 수 있다.)
            - forEach와의 차이점
                  : peek = 중간연산(스트림을 소비하지 않는다)
                  : forEach = 최종연산(스트림을 소비한다)
            - 실행 결과
            1. C
            2. C
            3. C
            1. C++
            2. C++
            3. C++
            1. C++
            1. CSS
            2. CSS
            3. CSS
            1. GO
            2. GO
            3. GO
            1. HTML
            2. HTML
            3. HTML
            1. JAVA
            2. JAVA
            3. JAVA
            1. JAVA
            1. JAVASCRIPT
            2. JAVASCRIPT
            3. JAVASCRIPT
            1. PYTHON
            2. PYTHON
            3. PYTHON
         */

        /*
            자바 9에서 추가된 takeWhile()과 dropWhile()
            - takeWhile : 조건이 true인 동안 요소를 반환하고, false가 되는 순간 이후는 모두 무시
            - dropWhile : 조건이 true인 동안 요소를 건너뛰고, false가 되는 순간 이후는 모두 반환
         */
        System.out.println("\n\n--- takeWhile ---");
        Stream.of(1, 2, 3, 4, 5, 4, 3, 2, 1)
                .takeWhile(i -> i < 3)
                .forEach(i -> System.out.print(i + " ")); // 1 2

        System.out.println("\n\n--- dropWhile ---");
        Stream.of(1, 2, 3, 4, 5, 4, 3, 2, 1)
                .dropWhile(i -> i < 3)
                .forEach(i -> System.out.print(i + " ")); // 3 4 5 4 3 2 1
    }

}
