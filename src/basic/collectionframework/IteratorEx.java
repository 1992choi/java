package basic.collectionframework;

import java.util.*;

public class IteratorEx {

    public static void main(String[] args) {
        /*
            Iterable
            - List, Set, Queue > Collection > Iterable 순서로 extends하는 관계를 가지고 있다.
            - Iterable 인터페이스의 주요 메서드 중 Iterator를 반환하는 iterator()가 있다.
            - Iterable은 하위 클래스에서 iterator()의 생성을 강제하는 역할을 하게 된다.
              따라서 Iterable을 상속받은 Collection의 하위 클래스들은 모두 iterator()를 가지고 있게 되며 hasNext(), next()등을 구현하고 있기 때문에 모든 요소를 쉽게 순회할 수 있다.
                - 개발자 입장에서 내부로직을 몰라도 모든 요소를 순회할 수 있으며, 다형성의 이점도 이용할 수 있게된다.
                  - 아래 예시에서 List, Set, Map을 순회하는 로직을 공통으로 뽑아낼 수 있다.
                    - while (iterator.hasNext()) { ... } 를 하나의 메서드로 분리할 수 있다는 의미.
         */

        /*
            Iterator
            - 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것.
         */
        Iterator iterator;

        // List 접근
        List<String> arrayList = new ArrayList<>();
        arrayList.add("가");
        arrayList.add("나");
        arrayList.add("다");
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // [가, 나, 다]
        }

        // Set 접근
        Set<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("kiwi");
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // [banana, apple, kiwi], 순서보장x
        }

        // Map 접근 (Map은 iterator()가 없어서 entrySet(), keySet(), values()을 호출해야한다.)
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "가");
        hashMap.put(2, "나");
        hashMap.put(3, "다");
        iterator = hashMap.entrySet().iterator(); // key, value에 접근
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // [1=가, 2=나, 3=다]
        }

        iterator = hashMap.keySet().iterator(); // key에 접근
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // [1, 2, 3]
        }

        iterator = hashMap.values().iterator(); // value에 접근
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // [가, 나, 다]
        }

    }

}
