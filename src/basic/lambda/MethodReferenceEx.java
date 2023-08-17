package basic.lambda;


import java.util.Arrays;
import java.util.function.Function;

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

class ParseUtils {
    public int convert(String num) {
        return Integer.parseInt(num);
    }
}

public class MethodReferenceEx {

    public static void main(String[] args) {
        /*
            메서드 참조는 람다 표현식이 단 하나의 메서드만을 호출하는 경우에
            해당 람다 표현식에서 불필요한 매개변수를 제거하고 사용할 수 있도록 해준다.
         */

        /** 정적 메서드 참조(Class::StaticMethod) */
        // 람다식 사용
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        int num1 = f1.apply("007");
        System.out.println(num1); // 7

        // 메서드 참조 사용
        Function<String, Integer> f2 = Integer::parseInt;
        int num2 = f2.apply("008");
        System.out.println(num2); // 8



        /** 생성자 참조(Class::new) */
        // 람다식 사용
        Function<String, User> f3 = s -> new User(s);
        User user1 = f3.apply("choi");
        System.out.println(user1.name); // choi

        // 메서드 참조 사용
        Function<String, User> f4 = User::new;
        User user2 = f4.apply("yg");
        System.out.println(user2.name); // yg



        /** 인스턴스 메서드 참조(Class::instanceMethod) */
        ParseUtils parseUtils = new ParseUtils();
        // 람다식 사용
        Function<String, Integer> f5 = s -> parseUtils.convert(s);
        System.out.println(f5.apply("001")); // 1

        // 메서드 참조 사용
        Function<String, Integer> f6 = parseUtils::convert;
        System.out.println(f5.apply("002")); // 2



        /** 그 외 */
        // 람다로 배열 생성
        Function<Integer, int[]> f7 = i -> new int[i];
        int[] arr1 = f7.apply(3);
        System.out.println(Arrays.toString(arr1)); // [0, 0, 0]

        // 메서드 참조로 배열 생성
        Function<Integer, int[]> f8 = int[]::new;
        int[] arr2 = f8.apply(5);
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0, 0]
    }

}
