package basic.lambda;


import java.util.Arrays;
import java.util.function.Function;

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

public class MethodReferenceEx {

    public static void main(String[] args) {
        /*
            메서드 참조는 람다 표현식이 단 하나의 메서드만을 호출하는 경우에
            해당 람다 표현식에서 불필요한 매개변수를 제거하고 사용할 수 있도록 해준다.
         */

        // 람다 표현식
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        int num1 = f1.apply("007");
        System.out.println(num1); // 7

        // 메서드 참조
        Function<String, Integer> f2 = Integer::parseInt;
        int num2 = f2.apply("008");
        System.out.println(num2); // 8



        // 람다 생성자 참조
        Function<String, User> f3 = s -> new User(s);
        User user1 = f3.apply("choi");
        System.out.println(user1.name); // choi

        // 메서드 생성자 참조
        Function<String, User> f4 = User::new;
        User user2 = f4.apply("yg");
        System.out.println(user2.name); // yg



        // 람다로 배열 생성
        Function<Integer, int[]> f5 = i -> new int[i];
        int[] arr1 = f5.apply(3);
        System.out.println(Arrays.toString(arr1)); // [0, 0, 0]

        // 메서드 참조로 배열 생성
        Function<Integer, int[]> f6 = int[]::new;
        int[] arr2 = f6.apply(5);
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0, 0]
    }

}
