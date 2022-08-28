package algorithm.doit;

public class Doit005 {

    /*
        주어진 배열(arr) 중 연속된 부분의 합을 m으로 나누었을 때,
        나누어 떨어지는 구간의 개수 구하기
     */
    static int solution(int[] arr, int m) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % m == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( "Answer : " + solution(new int[]{1, 2, 3, 1, 2}, 3)); // Answer : 7
    }
}