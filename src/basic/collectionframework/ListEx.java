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


        /* Vector - ArrayList와 유사하나 동기화 메서드로 구현되어 있어 멀티 쓰레드에 적합하다. */
        List<String> vector = new Vector<>();


        /* LinkedList - ArrayList와 유사하나 인덱스로 저장하는게 아닌 앞뒤 객체의 정보를 저장한다. */
        List<String> linkedList = new LinkedList<>();

        /*
            ArrayList와 LinkedList 성능비교
            1. ArrayList    - 검색 속도 빠름, 추가&삭제 느림
            2. LinkedList   - 검색 속도 느림, 추가&삭제 빠름
         */
    }

}
