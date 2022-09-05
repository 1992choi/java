package algorithm.doit;

import java.util.Arrays;

public class Doit012 {

    /*
        오큰수 구하기
        : 크기가 N인 수열 A(1), A(2), ... , A(N)이 주어질 때,
          A(i)의 오큰수를 구하려고 한다.
          A(i)의 오큰수는 A(i)보다 오른쪽에 있으면서 A(i)보다는 큰 수 중 가장 왼쪽에 있는 수를 의미한다.
          단, 오큰수가 없을 때는 =1을 반환한다.

          Ex) N개의 수 : 3, 5, 2, 7
              A(1)의 오큰수 = 5
              A(2)의 오큰수 = 7
              A(3)의 오큰수 = 7
              A(4)의 오큰수 = -1

              N개의 수 : 9, 5, 4, 8
              A(1)의 오큰수 = -1
              A(2)의 오큰수 = 8
              A(3)의 오큰수 = 8
              A(4)의 오큰수 = -1
     */
    static String solution(int[] nums) {
        String answer = "";
        for (int i = 0; i < nums.length; i++) {
            int compareNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (compareNum < nums[j]) {
                    compareNum = nums[j];
                    break;
                }
            }
            if (nums[i] == compareNum) {
                compareNum = -1;
            }
            answer += compareNum + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{3, 5, 2, 7})); // 5 7 7 -1
        System.out.println("Answer : " + solution(new int[]{9, 5, 4, 8})); // -1 8 8 -1
    }
}