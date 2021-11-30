package algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};

        for (int h = num.length / 2; h > 0; h /= 2) {
            for (int i = h; i < num.length; i++) {
                int j;
                int tmp = num[i];
                for (j = i - h; j >= 0 && num[j] > tmp; j -= h) {
                    num[j + h] = num[j];
                }
                num[j + h] = tmp;
            }
        }

        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
