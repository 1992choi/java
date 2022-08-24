package basic.stream;

import java.util.ArrayList;
import java.util.List;

public class ComparePerformance {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        // for 문으로 합계 구하기
        long start = System.currentTimeMillis();
        int size = list.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "]"); // sum = 1783293664 [4]

        // for 문으로 합계 구하기 [list.size() 그대로 사용]
        start = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "]"); // sum = 1783293664 [6]

        // for-each로 합계 구하기
        start = System.currentTimeMillis();
        sum = 0;
        for (int i : list) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "]"); // sum = 1783293664 [5]

        // for-each로 합계 구하기
        start = System.currentTimeMillis();
        sum = list.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "]"); // sum = 1783293664 [38]
    }

}
