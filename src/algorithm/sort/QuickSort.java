package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] num, int l, int r) {
        int left = l;
        int right = r;
        int pivot = num[(l + r) / 2];

        do {
            while (num[left] < pivot) {
                left++;
            }
            while (num[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);

        if (l < right) {
            quickSort(num, l, right);
        }
        if (r > left) {
            quickSort(num, left, r);
        }
    }

    public static void main(String[] args) {
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
