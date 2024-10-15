package kyh.mid1.lang.string.immutable;

public class StringImmutable {

    public static void main(String[] args) {
        /*
            불변객체
            - String은 불변객체이므로 생성 이후에 절대로 내부의 문자열 값을 변경할 수 없다.
            - concat() 메서드를 사용하면 기존 문자열에 새로운 문자열을 합칠 수 있지만,
              불변 객체의 특성상 실행된 값을 받아서 사용해야한다. (= Ex. str2 사용 예시)
            - String이 불변 객체로 설계된 이유 중 하나는 문자열 풀 때문이다.
              - 만약 가변 객체로 설계가 되었다면, 문자열 풀을 사용함에 있어서 같은 문자를 참조하는 변수가 모두 변경될 여지가 있기 때문이다.
         */
        String str = "hello";
        str.concat(" java");
        System.out.println("str = " + str); // hello

        String str1 = "hello";
        String str2 = str1.concat(" java");
        System.out.println("str1 = " + str1); // hello
        System.out.println("str2 = " + str2); // hello java
    }

}
