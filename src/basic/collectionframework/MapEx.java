package basic.collectionframework;

import java.util.*;

public class MapEx {

    public static void main(String[] args) {
        /* HashMap */
        Map<Integer, String> hashMap = new HashMap<>();
        // 요소 추가
        hashMap.put(1, "가");
        hashMap.put(2, "나");
        hashMap.put(3, "다");
        hashMap.put(4, "다"); // value는 중복이 가능하다.
        hashMap.put(5, "라");
        hashMap.put(5, "마"); // key는 중복이 불가능하여 덮어쓰여진다.
        System.out.println(hashMap); // {1=가, 2=나, 3=다, 4=다, 5=마}

        // key를 통한 값 변경
        hashMap.replace(4, "라");
        System.out.println(hashMap); // {1=가, 2=나, 3=다, 4=라, 5=마}

        // key, value를 통한 값 변경
        hashMap.replace(4, "라", "마");
        hashMap.replace(5, "바", "사"); // key는 일치하지만 value가 일치하지 않아 변경되지 않는다.
        System.out.println(hashMap); // {1=가, 2=나, 3=다, 4=마, 5=마}

        // key 확인
        System.out.println(hashMap.containsKey(1)); // true
        System.out.println(hashMap.containsKey(6)); // false

        // value 확인
        System.out.println(hashMap.containsValue("가")); // true
        System.out.println(hashMap.containsValue("하")); // false

        // key를 통한 값 제거
        hashMap.remove(1);
        System.out.println(hashMap); // {2=나, 3=다, 4=마, 5=마}

        // key, value를 통한 값 제거
        hashMap.remove(4, "마");
        hashMap.remove(5, "바"); // key는 일치하지만 value가 일치하지 않아 제거되지 않는다.
        System.out.println(hashMap); // {2=나, 3=다, 5=마}

        // clear
        hashMap.clear();


        /* Hashtable - HashMap과 유사하나 동기화 메서드로 구현되어 있어 멀티 쓰레드에 적합하다. */
        Map<Integer, String> hashtable = new Hashtable<>();


        /* LinkedHashMap - HashMap과 유사하나 입력 순서가 보장된다. */
        hashMap.put(5, "가");
        hashMap.put(2, "나");
        hashMap.put(1, "다");
        System.out.println(hashMap); // {1=다, 2=나, 5=가}
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(5, "가");
        linkedHashMap.put(2, "나");
        linkedHashMap.put(1, "다");
        System.out.println(linkedHashMap); // {5=가, 2=나, 1=다}


        /* TreeMap - HashMap과 유사하나 정렬 및 검색 기능이 추가되었다. */
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "아");
        treeMap.put(2, "나");
        treeMap.put(3, "자");
        treeMap.put(4, "가");
        treeMap.put(5, "하");
        System.out.println(treeMap); // {1=아, 2=나, 3=자, 4=가, 5=하}

        // 데이터 검색
        System.out.println(treeMap.firstKey()); // 1 : key중 가장 최솟값
        System.out.println(treeMap.lastKey()); // 5 : key중 가장 최댓값
        System.out.println(treeMap.firstEntry()); // 1=아 : key중 가장 최솟값인 쌍
        System.out.println(treeMap.lastEntry()); // 5=하 : key중 가장 최댓값인 쌍

        // 정렬
        System.out.println(treeMap.descendingMap()); // key 기준 내림차순으로 정렬된 쌍
        System.out.println(treeMap.descendingKeySet()); // key 기준 내림차순으로 정렬된 key값

        // 부분 집합 생성
        System.out.println(treeMap.headMap(3)); // {1=아, 2=나}
        System.out.println(treeMap.headMap(3, true)); // {1=아, 2=나, 3=자}
        System.out.println(treeMap.headMap(3, false)); // {1=아, 2=나}
        System.out.println(treeMap.tailMap(3)); // {3=자, 4=가, 5=하}
        System.out.println(treeMap.tailMap(3, true)); // {3=자, 4=가, 5=하}
        System.out.println(treeMap.tailMap(3, false)); // {4=가, 5=하}
    }

}
