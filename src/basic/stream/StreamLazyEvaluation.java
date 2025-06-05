package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLazyEvaluation {

    public static void main(String[] args) {
        /*
            - 지연 연산(Lazy Evaluation)의 개념
              - Stream의 중간 연산(filter, map 등)은 바로 실행되지 않고, 최종 연산(forEach, collect 등)이 호출될 때 실제로 실행된다.
              - 이렇게 지연 실행하는 이유는 전체 데이터를 모두 처리하지 않고, 필요한 만큼만 처리하여 성능을 최적화 할 수 있기 때문이다.
              - 예를 들어 filter와 map이 연결된 경우, 모든 요소를 먼저 필터링하고, 그 다음으로 map을 적용하는 게 아니라, 각 요소에 대해 순차적으로 filter → map → 최종 연산이 이루어진다.

              - 이점
                - 불필요한 연산을 줄일 수 있음 (예: 조건을 만족하지 않는 요소는 이후 연산 생략)
                - 메모리 사용량 최소화
                - 연산 순서를 최적화하여 성능 향상

             - 실행결과
                === 연산 시작 ===
                                      <----- filter와 map에서 콘솔에 찍힌 로그는 이때 출력되지 않는다. (지연 연산으로 인해 최종연산 시에 실행되기 때문)
                === 중간연산 종료 ===
                === 최종연산 시작 ===
                [filter] Alice
                [map] Alice
                [forEach] ALICE
                [filter] Bob
                [filter] Charlie
                                      <----- Bob과 Charlie는 지연연산 덕분에 map()이 실행되지 않아 성능상 이점을 얻은 모습을 볼 수 있다.
                === 최종연산 종료 ===
         */

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        System.out.println("=== 연산 시작 ===");
        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("[filter] " + name);
                    return name.startsWith("A");
                })
                .map(name -> {
                    System.out.println("[map] " + name);
                    return name.toUpperCase();
                });
        System.out.println("=== 중간연산 종료 ===");

        System.out.println("=== 최종연산 시작 ===");
        stream.forEach(result -> System.out.println("[forEach] " + result));
        System.out.println("=== 최종연산 종료 ===");
    }

}
