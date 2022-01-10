package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] num;
    public static int[] tmp = new int[8];

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            int p = start;
            int q = mid + 1;
            int idx = p;
            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && num[p] < num[q])) {
                    tmp[idx++] = num[p++];
                } else {
                    tmp[idx++] = num[q++];
                }
            }
            for (int i = start; i <= end; i++) {
                num[i] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
        num = new int[]{5, 9, 1, 6, 3, 2, 8, 7};

        mergeSort(0, num.length-1);

        System.out.println(Arrays.toString(num)); // [1, 2, 3, 5, 6, 7, 8, 9]
    }

}
