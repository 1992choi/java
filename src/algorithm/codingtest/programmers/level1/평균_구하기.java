package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12944
public class 평균_구하기 {

    public static double solution(int[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{5, 5}));
    }
}
