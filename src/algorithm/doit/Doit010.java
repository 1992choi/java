package algorithm.doit;

public class Doit010 {

    /*
        최솟값 찾기
        : N개의 수 A1, A2, ... , A(N)과 L이 주어질 때,
          A(i-L+1) ~ A(i) 중 최소값을 D(i)라 할 때 D에 저장된 수를 출력
          단, i가 음수인 경우의 A(i)의 값은 무시

          Ex) N개의 수 : 1 5 2 3 6 2 3 7 3 5 2 6
              L = 3

              ==> i가 0일 때,
                  : D(0) = A(0-3+1) ~ A(0)
                         = A(0) ~ A(0) 중 최소값은 0

              ==> i가 1일 때,
                  : D(1) = A(1-3+1) ~ A(1)
                         = A(0) ~ A(1) 중 최소값은 0

             ==> i가 2일 때,
                  : D(2) = A(2-3+1) ~ A(2)
                         = A(0) ~ A(2) 중 최소값은 0

             ==> i가 3일 때,
                  : D(3) = A(3-3+1) ~ A(3)
                         = A(1) ~ A(3) 중 최소값은 2
     */
    static String solution(int[] nums, int l) {
        String answer = "";
        for (int i = 0; i < nums.length; i++) {
            int startNum = i - l + 1;
            if (startNum < 0) {
                startNum = 0;
            }
            int minNum = nums[startNum];
            for (int j = startNum; j <= i; j++) {
                if (minNum > nums[j]) {
                    minNum = nums[j];
                }
            }
            answer += minNum + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6}, 3)); // 1 1 1 2 2 2 2 2 3 3 2 2
    }
}