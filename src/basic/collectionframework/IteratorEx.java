package basic.collectionframework;

import java.util.*;

public class IteratorEx {

    public static void main(String[] args) {
        // Iterator : 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화
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
