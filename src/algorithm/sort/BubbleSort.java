package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};

        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[j - 1] > num[j]) {
                    int tmp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
