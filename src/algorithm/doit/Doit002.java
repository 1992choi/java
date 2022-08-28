package algorithm.doit;

public class Doit002 {

    /*
        새로운 평균 구하기
        => 과목 중 최고점 M을 구해서 모든 점수에 아래의 식을 대입하여 다시 평균을 구한다.
           새로운 점수 계산법 : '점수 / M * 100'

        count = 과목 갯수
        score = 과목 점수
     */
    static double solution(int count, int[] score) {
//        double answer = 0;
//        int max = 0;
//        for (int i = 0; i < count; i++) {
//            if (max < score[i]) {
//                max = score[i];
//            }
//        }
//
//        for (int i = 0; i < count; i++) {
//            answer += (double) score[i] / max * 100;
//        }
//
//        return answer / count;

        // 수식을 사용하여 코드 단순화
        long max = 0;
        long sum = 0;
        for (int i = 0; i < count; i++) {
            if (max < score[i]) {
                max = score[i];
            }
            sum += score[i];
        }

        return sum * 100.0 / max / count;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{40, 80, 60})); // 75.0
        System.out.println(solution(3, new int[]{10, 20, 30})); // 66.66666666666667
        System.out.println(solution(4, new int[]{1, 100, 100, 100})); // 75.25
        System.out.println(solution(5, new int[]{1, 2, 4, 8, 16})); // 38.75
        System.out.println(solution(2, new int[]{3, 10})); // 65.0
    }
}