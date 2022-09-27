package basic.collectionframework;

import java.util.*;

public class RemoveListItem {

    /*
        리스트에서 특정 값 제거하기
        - 짝수 제거하기
    */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // for-each문 사용 : ConcurrentModificationException이 발생한다.
        System.out.println("======= for-each문 사용 =======");
        initList(list);
        System.out.println(list); // [1, 2, 6, 6, 2, 3, 3, 3, 5, 2, 5, 6, 6, 8, 5, 5, 8, 5]
        try {
            for (int num : list) {
                if (num % 2 == 0) {
                    list.remove(new Integer(num));
                }
            }
            System.out.println(list); // 오류 발생
        } catch (ConcurrentModificationException e) {
            System.out.println(e); // java.util.ConcurrentModificationException
        }



        // for문 사용 : 의도한 결과의 값이 나오지 않는다.
        System.out.println("======= for문 사용 - 정방향 탐색 =======");
        initList(list);
        System.out.println(list); // [1, 2, 6, 6, 2, 3, 3, 3, 5, 2, 5, 6, 6, 8, 5, 5, 8, 5]
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list); // [1, 6, 2, 3, 3, 3, 5, 5, 6, 5, 5, 5]



        // for문 사용 : 정상수행
        System.out.println("======= for문 사용 - 역방향 탐색 =======");
        initList(list);
        System.out.println(list); // [1, 2, 6, 6, 2, 3, 3, 3, 5, 2, 5, 6, 6, 8, 5, 5, 8, 5]
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list); // [1, 3, 3, 3, 5, 5, 5, 5, 5]



        // Iterator 사용 : 정상수행
        System.out.println("======= Iterator 사용 =======");
        initList(list);
        System.out.println(list); // [1, 2, 6, 6, 2, 3, 3, 3, 5, 2, 5, 6, 6, 8, 5, 5, 8, 5]
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int item = it.next();
            if (item % 2 == 0) {
                it.remove();
            }
        }
        System.out.println(list); // [1, 3, 3, 3, 5, 5, 5, 5, 5]



        // Collection.removeIf() 사용 : 정상수행
        System.out.println("======= Collection.removeIf() 사용 =======");
        initList(list);
        System.out.println(list); // [1, 2, 6, 6, 2, 3, 3, 3, 5, 2, 5, 6, 6, 8, 5, 5, 8, 5]
        list.removeIf(item -> item % 2 == 0);
        System.out.println(list); // [1, 3, 3, 3, 5, 5, 5, 5, 5]
    }

    private static void initList(List<Integer> list) {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(8);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(5);
    }

}
