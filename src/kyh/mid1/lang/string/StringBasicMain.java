package kyh.mid1.lang.string;

public class StringBasicMain {

    public static void main(String[] args) {
        /*
            - 자바에서의 문자
              - 자바에서 문자를 다루는 대표적인 타입은 `char` , `String` 2가지가 있다.
              - `char` 를 사용해서 여러 문자를 나열하려면 `char[]` 을 사용해야 한다.
                하지만 이렇게 `char[]` 을 직접 다루는 방법은 매우 불편하기 때문에 자바는 문자열을 매우 편리하게 다룰 수 있는 `String` 클래스를 제공한다.
         */
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(charArr);

        String str = "hello";
        System.out.println("str = " + str);

        /*
            - String 클래스 생성
              - String 클래스를 통해 문자열을 생성하는 방법은 2가지가 있다.
                - 쌍따옴표 사용: "hello"
                - 객체 생성: new String("hello");
              - 쌍따옴표로 문자열을 감싸면 자바 언어에서 `new String("hello")` 와 같이 변경해준다.
                - 성능 최적화를 위해 문자열 풀을 사용하기 때문
         */
        String str1 = "hello";
        String str2 = new String("hello");

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        /*
            - String 클래스와 참조형
              - String 클래스는 참조형이지만 + 연산이 가능하다.
              - 자주 다루어지는 클래스이다보니 편의상 특별히 제공하는 기능이라고 생각하면 된다.
              - concat() 메서드를 통해 문자열 결합 연산도 가능하다.
         */
        String a = "hello";
        String b = " java";
        String result1 = a.concat(b);
        String result2 = a + b;
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

}
