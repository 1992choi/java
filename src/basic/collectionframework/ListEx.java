package basic.collectionframework;

import java.util.*;

public class ListEx {

    public static void main(String[] args) {
        /* ArrayList */
        List<String> arrayList = new ArrayList<>();
        // 요소 추가
        arrayList.add("가");
        arrayList.add("나");
        arrayList.add("다");
        System.out.println(arrayList); // [가, 나, 다]

        // 인덱스를 통한 요소 추가
        arrayList.add(0, "라");
        System.out.println(arrayList); // [라, 가, 나, 다]

        // 값 변경
        arrayList.set(0, "마");
        System.out.println(arrayList); // [마, 가, 나, 다]

        // 인덱스를 통한 요소 삭제
        arrayList.remove(0);
        System.out.println(arrayList); // [가, 나, 다]

        // 값을 통한 요소 삭제
        arrayList.remove("나");
        System.out.println(arrayList); // [가, 다]

        // 배열로 값 반환
        Object[] obj = arrayList.toArray();
        System.out.println(Arrays.toString(obj)); // [가, 다]

        // 초기화 전
        System.out.println(arrayList); // [가, 다]
        System.out.println(arrayList.size()); // 2
        System.out.println(arrayList.isEmpty()); // false

        // 초기화 후
        arrayList.clear();
        System.out.println(arrayList); // []
        System.out.println(arrayList.size()); // 0
        System.out.println(arrayList.isEmpty()); // true

        // 인덱스 및 값을 통한 요소 삭제2
        List list2 = null;
        // 인덱스로 삭제
        list2 = new ArrayList<>();
        list2.add("1");
        list2.add(2);
        list2.add(1);
        System.out.println(list2); // [1, 2, 1]
        list2.remove(1);
        System.out.println(list2); // [1, 1] : 1번째 인덱스인 2가 삭제됨.
        // 요소로 삭제
        list2 = new ArrayList<>();
        list2.add("1");
        list2.add(2);
        list2.add(1);
        System.out.println(list2); // [1, 2, 1]
        list2.remove(new Integer(1));
        System.out.println(list2); // [1, 2] : 숫자 1이 삭제됨.

        // A.retainAll(B) : A의 요소 중 B에 존재하는 요소만 남기고 삭제한다.
        List<String> listA = null;
        List<String> listB = null;
        // listA.retainAll(listB);
        listA = new ArrayList<>();
        listA.add("A"); listA.add("B"); listA.add("C"); listA.add("H");
        listB = new ArrayList<>();
        listB.add("B"); listB.add("C"); listB.add("D");
        System.out.println(listA); // [A, B, C, H]
        System.out.println(listB); // [B, C, D]
        listA.retainAll(listB);
        System.out.println(listA); // [B, C]
        System.out.println(listB); // [B, C, D]
        // listB.retainAll(listA);
        listA = new ArrayList<>();
        listA.add("A"); listA.add("B"); listA.add("C"); listA.add("H");
        listB = new ArrayList<>();
        listB.add("B"); listB.add("C"); listB.add("D");
        System.out.println(listA); // [A, B, C, H]
        System.out.println(listB); // [B, C, D]
        listB.retainAll(listA);
        System.out.println(listA); // [A, B, C, H]
        System.out.println(listB); // [B, C]

        // Arrays.asList()를 사용한 ArrayList 생성
        List<String> arraysAsList = new ArrayList(Arrays.asList("A", "B", "C", "D"));



        /* Vector - ArrayList와 유사하나 동기화 메서드로 구현되어 있어 멀티 쓰레드에 적합하다. */
        List<String> vector = new Vector<>();


        /* LinkedList - ArrayList와 유사하나 인덱스로 저장하는게 아닌 앞뒤 객체의 정보를 저장한다. */
        List<String> linkedList = new LinkedList<>();

        /*
            ArrayList와 LinkedList 성능비교
            1. ArrayList    - 검색 속도 빠름, 추가&삭제 느림(순차적 추가&삭제는 더 빠르다.)
                               * ArrayList의 요소를 순차적으로 삭제할 경우, 뒤에서부터 순차적으로 삭제한다면 배열의 복사가 발생하지 않는다.
            2. LinkedList   - 검색 속도 느림, 추가&삭제 빠름
         */
    }

}
