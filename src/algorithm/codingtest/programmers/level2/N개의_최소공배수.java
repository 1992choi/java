package algorithm.codingtest.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12953
public class N개의_최소공배수 {

    public static int solution(int[] arr) {
        int answer = 0;

        long range = 1;
        for (int num : arr) {
            range *= num;
        }

        for (int i = 2; i <= range; i++) {
            int divCnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i % arr[j] == 0) {
                    divCnt++;
                }
            }
            if (divCnt == arr.length) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }
}
