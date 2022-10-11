package algorithm.doit;

public class Doit005 {

    /*
        주어진 배열(arr) 중 연속된 부분의 합을 m으로 나누었을 때,
        나누어 떨어지는 구간의 개수 구하기
     */
    static int solution(int[] arr, int m) {
//        int answer = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0;
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum % m == 0) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;




        /** 구간 합을 사용한 방식 */
        int answer = 0;
        int[] sumArr = new int[arr.length]; // 합 배열
        int[] remainderArr = new int[m]; // 같은 나머지의 인덱스를 카운트하는 배열

        // 구간 합 만들기
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        // 합 배열의 모든 값에 % 연산 수행
        for (int i = 0; i < arr.length; i++) {
            int remainder = sumArr[i] % m;
            if (remainder == 0) { // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
                answer++;
            }

            remainderArr[remainder]++; // 나머지가 같은 인덱스의 개수 카운트
        }

        for (int i = 0; i < m; i++) {
            if (remainderArr[i] > 1) {
                answer += remainderArr[i] * (remainderArr[i] - 1) / 2; // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( "Answer : " + solution(new int[]{1, 2, 3, 1, 2}, 3)); // Answer : 7
    }
}