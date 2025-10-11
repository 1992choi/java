package javamistakes;

import java.time.LocalDate;

/*
    문자열 포맷
    - String.format()과 PrintStream.printf() 등의 메서드는 포맷 문자열과 추가 인수를 받는다.
      이 때 포맷고 인수가 올바르게 매칭되지 않는다면, 의도와 다른 문자열을 출력할 것이다.

    올바른 문자열 포맷을 위해서는
    - 문자열 포맷을 구성하는 메서드를 별도로 분리하여 테스트 코드를 작성할 수 있게 구성한다.
    - 인수에 인덱스를 추가하여, 동적 매칭이 가능하도록 작성한다.
 */
public class Ex048_StringFormat {

    public static void main(String[] args) {
        // 올바른 문자열 포맷으로 치환되었는지 검증을 위해 메서드 분리 후 단위 테스트를 만드는 것이 실수를 방지하는 방법이다.
        System.out.printf("Hello, %s!\n", "choi");
        System.out.println(getGreetStr("choi")); // getGreetStr() 메서드를 단위 테스트로 검증할 수 있게 된다.

        // 만약 문자 구성이 변경될 때, 인자의 순서는 변경되지 않는다면 의도와 다른 문자가 출력될 수 있다.
        // ASIS : Today is %tD, Hello, %s!
        // TOBE : Hello, %s! Today is %tD
        // System.out.printf("Hello, %s! Today is %tD", LocalDate.now(), "choi"); // 미처 인자를 변경하지 않아서 의도와 다른 문장이 나오거나 오류 발생.

        // 이를 방지하기 위하여 아래와 같이 순서를 정해주면, 순서가 변경되거나 중간에 인자가 추가되어도 안전하게 포매팅할 수 있다.
        System.out.printf("Hello, %2$s! Today is %1$tD", LocalDate.now(), "choi");
    }

    public static String getGreetStr(String name) {
        return String.format("Hello, %s!\n", name);
    }

}
