package basic.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambda {

    public static void main(String[] args) {

        // 기존 정렬
        List<String> list = Arrays.asList("zzz", "aaa", "ccc", "ddd", "abc", "bbb");
        System.out.println(list); // [zzz, aaa, ccc, ddd, abc, bbb]
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list); // [aaa, abc, bbb, ccc, ddd, zzz]

        // 람다를 사용한 정렬
        list = Arrays.asList("zzz", "aaa", "ccc", "ddd", "abc", "bbb");
        System.out.println(list); // [zzz, aaa, ccc, ddd, abc, bbb]
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        System.out.println(list); // [aaa, abc, bbb, ccc, ddd, zzz]

    }
}
