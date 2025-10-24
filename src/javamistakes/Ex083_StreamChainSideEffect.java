package javamistakes;

import java.util.ArrayList;
import java.util.List;

/*
    스트림 API 체인에서 부수 효과를 일으킴
    - 스트림 API는 원천으로부터 스트림을 생성하고, 중간연산을 처리하고, 단말연산을 처리한다.
      이때 중간연산이 함수를 입력 받는 경우, 스트림은 이 함수가 부수효과를 일으키지 않는다고 간주하는데, 이를 위반한 코드를 작성해서는 안된다.

    - 실수 방지 가이드
      - 스트림 API의 정확한 원리를 모른다면, 중간 연산에서 부수 효과를 완전히 배제하는 것이 낫다.
      - 스트림은 간편하지만 충분히 표현을 할 수 없는 경우에는 for 루프로 풀어서 작성하는 편이 좋다. (비즈니스 로직을 억지로 stream에 끼워맞추지 말기)

 */
public class Ex083_StreamChainSideEffect {

    public static void main(String[] args) {
        List<String> param = List.of("java", "spring", "bean", "security");
        List<String> wordsLongerThanFive = new ArrayList<>();

        /*
            부수효과를 일으키는 예시
            - stream 중간연산에서 외부의 있는 변수(=wordsLongerThanFive)에 데이터를 누적하고 있다.

              .filter() 코드가 있다면, 실행결과는 [spring, security]가 나온다.
              하지만 주석이 되어있다면 빈배열([])이 출력된다.

              이는 내부적으로 구현을 최적화하기 때문이고, 상세적인 내용으로는 아래와 같이 동작하기 때문이다.
              자바8에서 count는 연산이 스트림 원소를 일일이 소비했지만, 자바 9부터는 원소의 개수가 변경되지 않는다면 반복 처리 과정이 아예 생략될 수 있다.
              따라서 현재버전(9이상임)에서는 filter가 주석되면 원소의 갯수가 달라지지 않으니 반복 처리 과정이 생략되어 wordsLongerThanFive.add()도 생략되기 때문에 빈배열이 출력되는 것이다.

              이처럼 내부 원리를 정확하게 모르는 상태로 부수효과를 주는 코드를 작성하게되면, 개발자의 의도와 다른 결과를 초래할 수 있다.
         */
        long wordsLongerThanFiveCount = param.stream()
                .map(String::trim)
                // .filter(s -> s.length() > 5)
                .peek(wordsLongerThanFive::add)
                .count();

        System.out.println(wordsLongerThanFive);
    }

}
