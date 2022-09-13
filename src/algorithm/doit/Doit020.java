package algorithm.doit;

import java.util.Arrays;

public class Doit020 {

    /*
        수 정렬하기 2
          - N개의 수가 주어졌을 때, 오름차순으로 정렬 (단, 병합정렬 사용하기)
     */

    public static int[] num;
    public static int[] tmp;

    static int[] solution(int[] arr) {
        num = arr;
        tmp = new int[arr.length];

        mergeSort(0, num.length - 1);

        return arr;
    }

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
        System.out.println("Answer : " + Arrays.toString(solution(new int[]{5, 4, 3, 2, 1}))); // Answer : [1, 2, 3, 4, 5]
    }
}