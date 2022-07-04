package basic.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Predicate는 Type T 인자를 받고 boolean을 리턴하는 함수형 인터페이스의 한 종류이다.
public class PredicateEx {

    public static void main(String[] args) {
        // 빈 문자인지 비교하여 제거
        List<String> list = Arrays.asList("Java", "C", "", "Python", "", "Kotlin");
        Predicate<String> noneEmptyStringPredicate = s -> !s.isEmpty();
        for (String s : list) {
            boolean result = noneEmptyStringPredicate.test(s);
            if (result) {
                System.out.println(s);
                /* 출력결과
                    Java
                    C
                    Python
                    Kotlin
                 */
            }
        }

        // Stream의 filter()에 인자로 전달
        list.stream().filter(noneEmptyStringPredicate).forEach(System.out::println);
        /* 출력결과
            Java
            C
            Python
            Kotlin
         */



        /*
            AND연산 및 OR연산
            - Predicate의 결과를 AND 연산하거나 OR 연산할 수 있습니다.
         */
        Predicate<Integer> cond1 = (num) -> num > 10;
        Predicate<Integer> cond2 = (num) -> num > 20;
        boolean result;

        // AND연산
        result = cond1.and(cond2).test(15);
        System.out.println(result); // false

        // OR연산
        result = cond1.or(cond2).test(15);
        System.out.println(result); // true



        /*
            isEquals 연산
            - 인자로 전달된 객체와 같은지 확인한다.
         */
        String str1 = new String("abc");
        String str2 = new String("abc");
        Predicate<String> IsEqualPredicate = Predicate.isEqual(str1);
        System.out.println(IsEqualPredicate.test(str2)); // true
    }

}
