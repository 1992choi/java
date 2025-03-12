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

        /*
            선언과 동시에 초기화
            - 이중 중괄호 구문을 사용하여 구현할 수 있으나,
              익명의 추가 클래스를 생성하기 때문에 메모리 누수 문제가 발생할 수 있다.
        */
        Map<String, String> initMap = new HashMap() {
            {
                put("choi", "10");
                put("choi", "31");
                put("kim", "20");
                put("lee", "40");
            }
        };
        System.out.println(initMap); // {choi=31, lee=40, kim=20}

        // 자주 사용되는 메서드
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        System.out.println(map.get("a")); // 1
        System.out.println(map.getOrDefault("b", 0)); // 0: key에 해당하는 값이 없을 때 defaultValue를 가져온다.
        // a의 값을 1씩 누적시키는 예제 : map.put("a", map.getOrDefault("a", 0) + 1);
        // 다른 메서드로도 표현이 가능하다 : map.compute("a", (key, value) -> (value == null) ? 1 : value + 1);

        System.out.println(map.compute("a", (key, value) -> value + 1)); // 2: key에 해당하는 값에 연산을 한다. 'map.put("a", map.get("a") + 1);'과 유사하나 멀티스레드 환경에서는 compute()가 적합하다. put() + get() 방식은 각 메서드가 경쟁 상태 가능성이 있음.
        System.out.println(map); // {a=2}
        // System.out.println(map.compute("c", (key, value) -> value + 1)); // NPE: c에 해당하는 값이 없는데 +1 연산을 하므로 NPE 발생.

        /*
            computeIfAbsent();
            - 키가 존재하지 않을 때만 새 값을 계산하여 추가한다.
            - 키가 이미 존재하면 기존 값을 변경하지 않는다.
         */
        map.computeIfAbsent("b", key -> 10); // b가 없으므로 b에 10을 계산하여 추가.
        map.computeIfAbsent("a", key -> 10); // a가 있으므로 아무것도 변경하지 않음.
        System.out.println(map); // {a=2, b=10}

        /*
            computeIfPresent();
            - 키가 존재할 때만 새 값을 계산하여 업데이트한다.
            - 키가 존재하지 않으면 아무 일도 하지 않는다.
         */
        map.computeIfPresent("a", (key, value) -> value + 10); // a가 있으므로 a에 +10 연산.
        map.computeIfPresent("c", (key, value) -> value + 10); // c가 없으므로 아무것도 변경하지 않음.
        System.out.println(map); // {a=12, b=10}

        /*
            putIfAbsent();
            - 키가 없으면 value를 추가한다.
            - 키가 있으면 기존 값을 유지하고 아무 동작도 하지 않는다.
         */
        map.putIfAbsent("d", 10); // d가 없으므로 새로운 값 10을 추가.
        map.putIfAbsent("a", 100); // a가 있으므로 값이 변경되지 않음.
        System.out.println(map); // {a=12, b=10, d=10}

        /*
            putIfAbsent()와 computeIfAbsent() 차이점
            - 둘다 값이 없을 때 연산을 진행하는 점에서 유사하다고 느낄 수 있지만, 아래와 같은 차이점이 존재한다.
            - putIfAbsent() : 값이 고정되어 있을 때 사용
              - map.putIfAbsent("a", 10); // "a"가 없으면 10을 저장
            - computeIfAbsent() : 값이 동적으로 계산될 때 사용
              - map.computeIfAbsent("a", key -> key.length()); // "a"가 없으면 key.length() 값을 계산해서 저장
         */
    }

}
