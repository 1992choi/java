package basic.stream;

import java.util.ArrayList;
import java.util.List;

public class ComparePerformance {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        // for 문으로 합계 구하기
        long start = System.currentTimeMillis();
        long size = list.size();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [18ms]

        // for 문으로 합계 구하기 [list.size() 그대로 사용]
        start = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [15ms]

        // for-each로 합계 구하기
        start = System.currentTimeMillis();
        sum = 0;
        for (long l : list) {
            sum += l;
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [15ms]

        // Stream API로 합계 구하기
        start = System.currentTimeMillis();
        sum = list.stream().reduce(0L, Long::sum);
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [69ms]
    }

}
