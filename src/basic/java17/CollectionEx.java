package basic.java17;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionEx {

    public static void main(String[] args) {
        /*
            Collection Factory Method 강화
            - Set, List, Map 인터페이스에 Immutable 하게 생성할 수 있는 새로운 메서드가 추가되었다.
         */

        Set<String> set = Set.of("a", "b", "c");
        System.out.println(set); // [a, b, c]
        // set.add("d"); // java.lang.UnsupportedOperationException 오류 발생

        List<String> list = List.of("a", "b", "c");
        System.out.println(list);
        // list.add("d"); // java.lang.UnsupportedOperationException 오류 발생

        Map<String, String> map = Map.of(
                "a", "111",
                "b", "222",
                "c", "333"
        );
        System.out.println(map);
        // map.put("d", "444"); // java.lang.UnsupportedOperationException 오류 발생
    }

}
