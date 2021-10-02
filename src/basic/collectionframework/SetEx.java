package basic.collectionframework;

import java.util.*;

public class SetEx {

    public static void main(String[] args) {
        /* HashSet */
        Set<String> hashSet = new HashSet<>();
        // 요소 추가
        hashSet.add("가");
        hashSet.add("나");
        hashSet.add("가"); // 중복을 허용하지 않는다.
        hashSet.add("다");
        System.out.println(hashSet); // [가, 다, 나] : HashSet은 추가한 순서대로 출력되지 않는다.

        // 요소 삭제
        hashSet.remove("다");
        System.out.println(hashSet); // [가, 나] : HashSet은 추가한 순서대로 출력되지 않는다.
        
        // 요소 확인
        System.out.println(hashSet.contains("나")); // true
        System.out.println(hashSet.contains("다")); // false

        // 모든 요소 출력
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()); // 저장되어있던 가, 나를 하나씩 출력
        }


        /* LinkedHashSet - HashSet과 유사하나 입력 순서가 보장된다. */
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("라");
        linkedHashSet.add("다");
        linkedHashSet.add("나");
        linkedHashSet.add("가");
        System.out.println(linkedHashSet); // [라, 다, 나, 가]


        /* TreeSet - HashSet과 유사하나 정렬 및 검색 기능이 추가되었다. */
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("라");
        treeSet.add("바");
        treeSet.add("나");
        treeSet.add("다");
        treeSet.add("가");
        treeSet.add("마");
        System.out.println(treeSet); // [가, 나, 다, 라, 마, 바] : 크기 순으로 출력
        System.out.println(treeSet.first()); // 가 : 원소 중 가장 작은 원소값 출력
        System.out.println(treeSet.last()); // 바 : 원소 중 가장 큰 원소값 출력

        // 데이터 꺼내기
        System.out.println(treeSet.pollFirst()); // 가
        System.out.println(treeSet.pollFirst()); // 나
        System.out.println(treeSet.pollLast()); // 바
        System.out.println(treeSet); // [다, 라, 마] : pollFirst() 또는 pollLast()를 통해 데이터를 꺼내면 저장된 원소에서 제거된다.

        // 데이터 정렬
        NavigableSet<String> navigableSet = treeSet.descendingSet();
        System.out.println(navigableSet); // [마, 라, 다]
        System.out.println(navigableSet.descendingSet()); // [다, 라, 마]

        // 부분 집합 생성
        treeSet.add("가");
        treeSet.add("나");
        treeSet.add("바");
        System.out.println(treeSet); // [가, 나, 다, 라, 마, 바]
        System.out.println(treeSet.headSet("다")); // [가, 나] : 파라미터 미만 데이터(포함x)
        System.out.println(treeSet.headSet("다", true)); // [가, 나, 다] : 파라미터 이하 데이터(포함o)
        System.out.println(treeSet.tailSet("다")); // [다, 라, 마, 바] : 파라미터 이상 데이터(포함o)
        System.out.println(treeSet.tailSet("다", false)); // [라, 마, 바] : 파리미터 초과 데이터(포함x)
        System.out.println(treeSet.subSet("나", "라")); // [나, 다]
        System.out.println(treeSet.subSet("나", true, "라", true)); // [나, 다, 라]
    }

}
