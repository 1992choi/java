package basic.stream;

import java.util.List;
import java.util.stream.IntStream;

public class Parallel {

    public static void main(String[] args) {
        /*
            자바 병렬 스트림
            - 병렬 스트림은 Fork/Join 공용 풀을 사용해서 병렬 연산을 수행한다.
            - 실행 결과를 보면 여러 스레드가 병렬로 해당 업무를 처리하기 때문에 수행시간이 단축된 것을 알 수 있다.

            Fork/Join
            - 분할(Fork), 처리(Execute), 모음(Join)
              - 스레드는 한 번에 하나의 작업을 처리할 수 있다.
              - 따라서 하나의 큰 작업을 여러 스레드가 처리할 수 있는 작은 단위의작업으로 분할(Fork)해야 한다.
              - 그리고 이렇게 분할한 작업을 각각의 스레드가 처리(Execute)하는 것이다. 각 스레드의 분할된 작업 처리가 끝나면 분할된 결과를 하나로 모아야(Join) 한다.
              - 이렇게 분할(Fork), 처리(Execute), 모음(Join)의 단계로 이루어진 멀티스레딩 패턴을 'Fork/Join 패턴'이라고 부른다.
            - Fork/Join 프레임워크
              - 자바의 Fork/Join 프레임워크는 자바 7부터 도입된 'java.util.concurrent' 패키지의 일부로, 멀티코어 프로세서를 효율적으로 활용하기 위한 병렬 처리 프레임워크이다.
              - 주요 개념
                - 분할 정복(Divide and Conquer) 전략
                  - 큰 작업(task)을 작은 단위로 재귀적으로 분할(fork)
                  - 각 작은 작업의 결과를 합쳐(join) 최종 결과를 생성
                  - 멀티코어 환경에서 작업을 효율적으로 분산 처리
                - 작업 훔치기(Work Stealing) 알고리즘
                  - 각 스레드는 자신의 작업 큐를 가짐
                  - 작업이 없는 스레드는 다른 바쁜 스레드의 큐에서 작업을 '훔쳐와서' 대신 처리
                  - 부하 균형을 자동으로 조절하여 효율성 향상
         */
        List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().toList();

        // Sequential Stream
        long startTime = System.currentTimeMillis();
        numbers.forEach(Parallel::slowOperation);
        System.out.println("Sequential Stream time: " + (System.currentTimeMillis() - startTime) + " ms"); // Sequential Stream time: 5019 ms

        // Parallel Stream
        startTime = System.currentTimeMillis();
        numbers.parallelStream().forEach(Parallel::slowOperation);
        System.out.println("Parallel Stream time: " + (System.currentTimeMillis() - startTime) + " ms"); // Parallel Stream time: 1018 ms
    }

    private static void slowOperation(Integer n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
