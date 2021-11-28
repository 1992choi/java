package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};

        for (int i = 0; i < num.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[min]) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
