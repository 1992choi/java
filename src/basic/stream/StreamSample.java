package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample {

    public static void main(String[] args) {
        /*
            - 스트림이란?
              : 컬렉션에 저장된 요소를 하나씩 참조하여 람다식으로 처리할 수 있도록 해주는 기능

            - 스트림의 작업 흐름 순서
              : 생성 > 중개 연산(Intermediate Operation) > 최종 연산(Terminal Operation)

            - 단계별 종류
              : 1.생성
                  1-1.컬렉션
                  1-2.배열
                  1-3.가변 매개변수
                  1-4.지정된 범위의 연속된 정수
                  1-5.특정 타입의 난수들
                  1-6.람다 표현식
                  1-7.파일
                  1-8.빈 스트림
              : 2.중개 연산(Intermediate Operation)
                  2-1.스트림 필터링 : filter(), distinct()
                  2-2.스트림 변환 : map(), flatMap()
                  2-3.스트림 제한 : limit(), skip()
                  2-4.스트림 정렬 : sorted()
                  2-5.스트림 연산 결과 확인 : peek()
              : 3.최종 연산(Terminal Operation)
                  3-1.출력 : forEach()
                  3-2.소모 : reduce()
                  3-3.검색 : findFirst(), findAny()
                  3-4.검사 : anyMatch(), allMatch(), noneMatch()
                  3-5.통계 : count(), min(), max()
                  3-6.연산 : sum(), average()
                  3-7.수집 : collect()
        */


        // 1. 생성 - 컬렉션에서 스트림 생성
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> originStream = list.stream();

        // 2. 중개 연산 - 스트림 변환
        Stream<String> upperStream = originStream.map(s -> s.toUpperCase());

        // 3. 최종 연산 - 출력
        upperStream.forEach(a -> System.out.print(a + " ")); // 'A B C' 출력
    }

}
