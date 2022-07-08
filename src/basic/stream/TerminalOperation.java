package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperation {

    public static void main(String[] args) {

        /*
            * 최종 연산(Terminal Operation)
              - 출력 : forEach(), forEachOrdered()
              - 소모 : reduce()
              - 검색 : findFirst(), findAny()
              - 검사 : anyMatch(), allMatch(), noneMatch()
              - 통계 : count(), min(), max()
              - 연산 : sum(), average()
              - 수집 : collect()
         */

        System.out.println("\n\n--- forEach ---");
        // 원소를 출력한다.
        Arrays.asList(5, 6, 8, 1, 9, 1, 3, 8, 7)
                .stream()
                .forEach(s -> System.out.print(s + " ")); // 5 6 8 1 9 1 3 8 7



        System.out.println("\n\n--- forEach(parallel) ---");
        Arrays.asList(5, 6, 8, 1, 9, 1, 3, 8, 7)
                .stream()
                .parallel() // 병렬처리
                .forEach(s -> System.out.print(s + " ")); // 1 9 8 7 3 8 1 6 5 : 병렬처리로 인하여 순서가 보장되지 않는다.



        System.out.println("\n\n--- forEachOrdered(parallel) ---");
        Arrays.asList(5, 6, 8, 1, 9, 1, 3, 8, 7)
                .stream()
                .parallel() // 병렬처리
                .forEachOrdered(s -> System.out.print(s + " ")); // 5 6 8 1 9 1 3 8 7 : forEachOrdered를 사용하면 순서가 보장된다.



        System.out.println("\n\n--- reduce ---");
        // 두 개의 인자 n, n+1을 가질 때, 연산결과는 n이 되고 다시 다음 요소와 연산을 하게된다.
        // 즉 1, 2번째 요소를 연산하고 그 연산 결과를 3번째 요소와 다시 연산하는 방식이다.
        System.out.println(
                Arrays.asList(1, 2, 3, 4)
                        .stream()
                        .reduce((a, b) -> (a + b)).get()
        ); // 10



        System.out.println("\n\n--- findFirst ---");
        // findFirst()는 보통 filter()와 함께 사용되며, 스트림에서 지정된 첫 번째 요소를 찾는 함수이다.
        Arrays.asList("c", "c++", "java", "javascript", "go", "python")
                .stream()
                .filter(s -> s.startsWith("j"))
                .findFirst()
                .ifPresent(System.out::print); // java



        System.out.println("\n\n--- findAny ---");
        // findAny()는 parallelStream()에서 병렬 처리 시, 가장 먼저 발견된 요소를 찾는 메서드로 결과는 스트림 원소의 정렬 순서와 상관 없다.
        Arrays.asList("c", "c++", "java", "javascript", "go", "python")
                .parallelStream()
                .filter(s -> s.startsWith("j"))
                .findAny()
                .ifPresent(System.out::print); // java 또는 javascript



        System.out.println("\n\n--- anyMatch ---");
        // 원소 중 일부라도 일치하는게 있는지 확인한다.
        System.out.println(
                Arrays.asList("c", "c++", "java", "javascript", "go", "python")
                        .stream()
                        .anyMatch(s -> s.startsWith("j"))
        ); // true



        System.out.println("\n\n--- allMatch ---");
        // 원소 전체가 일치하는지 확인한다.
        System.out.println(
                Arrays.asList("c", "c++", "java", "javascript", "go", "python")
                        .stream()
                        .allMatch(s -> s.startsWith("j"))
        ); // false



        System.out.println("\n\n--- noneMatch ---");
        // 원소가 모두 일치하지 않는지 확인한다.
        System.out.println(
                Arrays.asList("c", "c++", "java", "javascript", "go", "python")
                        .stream()
                        .noneMatch(s -> s.startsWith("a"))
        ); // true



        System.out.println("\n\n--- count ---");
        // 원소의 갯수를 구한다.
        System.out.println(
                Arrays.asList(5, 8, 1, 2, 4, 3)
                        .stream()
                        .count()
        ); // 6



        System.out.println("\n\n--- min ---");
        // 원소 중 최솟값을 구한다.
        System.out.println(
                Arrays.asList(5, 8, 1, 2, 4, 3)
                        .stream()
                        .min(Integer::compare)
                        .get()
        ); // 1



        System.out.println("\n\n--- max ---");
        // 원소 중 최댓값을 구한다.
        System.out.println(
                Arrays.asList(5, 8, 1, 2, 4, 3)
                        .stream()
                        .max(Integer::compare)
                        .get()
        ); // 8



        System.out.println("\n\n--- sum ---");
        // 원소의 합을 구한다.
        System.out.println(
                Arrays.asList(5, 8, 1, 2, 4, 3)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum()
        ); // 23



        System.out.println("\n\n--- average ---");
        // 원소의 평균을 구한다.
        System.out.println(
                Arrays.asList(5, 8, 1, 2, 4, 3)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average()
        ); // 3.833...



        System.out.println("\n\n--- collect ---");
        // 스트림을 배열이나 컬렉션으로 변환한다.
        List<Integer> intList = Arrays.asList(5, 8, 1, 2, 4, 3)
                                    .stream()
                                    .collect(Collectors.toList());
        System.out.println(intList); // [5, 8, 1, 2, 4, 3]
    }

}
