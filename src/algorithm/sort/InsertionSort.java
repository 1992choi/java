package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};

        for (int i = 1; i < num.length; i++) {
            int j;
            int tmp = num[i];
            for (j = i; j > 0 && num[j - 1] > tmp; j--) {
                num[j] = num[j - 1];
            }
            num[j] = tmp;
        }

        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
