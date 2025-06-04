package basic.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaCapturingWithFinal {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        /*
            람다의 외부 지역 변수 참조
            - 람다식은 외부 지역 변수를 캡처(참조)할 수 있다.
            - 단, 이 변수는 "절대 바뀌지 않는 값"이라는 전제로 캡처된다.
            - 즉, Java에서는 람다식에서 사용할 외부 변수는 final이거나 effectively final이어야 한다.
              - effectively final은 final은 아니지만, 실제로는 값 변경이 없어 final로 간주되는 것을 의미한다.
         */

        // effectively final(사실적 final)이기 때문에 가능
        String immutablePrefix = "이름 : ";
        names.stream().forEach(s -> System.out.println(immutablePrefix + s));

        // 변하기 때문에 컴파일 오류 발생.
        String mutablePrefix = "이름 : ";
        mutablePrefix = "이름 -> ";
        // names.stream().forEach(s -> System.out.println(mutablePrefix + s)); // 컴파일 오류
    }

}
