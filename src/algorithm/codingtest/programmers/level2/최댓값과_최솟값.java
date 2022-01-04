package algorithm.codingtest.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12939
public class 최댓값과_최솟값 {

    public static String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            int currentVal = Integer.parseInt(arr[i]);
            if (min > currentVal) {
                min = currentVal;
            }
            if (max < currentVal) {
                max = currentVal;
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
