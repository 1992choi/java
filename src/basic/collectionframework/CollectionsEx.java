package basic.collectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEx {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list); // []

        // 채우기
        Collections.addAll(list, "A", "B", "C", "D", "E");
        System.out.println(list); // [A, B, C, D, E]

        // 우측으로 회전
        Collections.rotate(list, 2);
        System.out.println(list); // [D, E, A, B, C]

        // 값 교환
        Collections.swap(list, 0, 3);
        System.out.println(list); // [B, E, A, D, C]

        // 값 섞기
        Collections.shuffle(list);
        System.out.println(list); // [A, E, C, B, D]

        // 정렬
        Collections.sort(list);
        System.out.println(list); // [A, B, C, D, E]

        // 역순 정렬
        Collections.reverse(list);
        System.out.println(list); // [E, D, C, B, A]

        // 최대값
        System.out.println(Collections.max(list)); // E

        // 최소값
        System.out.println(Collections.min(list)); // A

        // 치환
        Collections.replaceAll(list, "A", "Z");
        System.out.println(list); // [E, D, C, B, Z]

        // 채우기
        Collections.fill(list, "A");
        System.out.println(list); // [A, A, A, A, A]

    }

}
