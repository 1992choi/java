package basic.controlstatements;

import java.util.ArrayList;
import java.util.List;

public class CollectionSize {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long beforeTime;
        int sum;
        for(int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        // size()를 사용하여 반복
        sum = 0;
        beforeTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(System.currentTimeMillis() - beforeTime); // 16

        // for each
        sum = 0;
        beforeTime = System.currentTimeMillis();
        for (int i : list) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - beforeTime); // 15

        // 변수에 할당 후 반복
        sum = 0;
        beforeTime = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - beforeTime); // 6
    }

}
