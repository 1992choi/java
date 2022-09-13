package algorithm.doit;

public class Doit021 {

    /*
        버블 소트 프로그램 2
          - 버블 소트를 수행할 때, swap 발생 횟수 구하기
            단, 오름차순으로 정렬
     */
    static int solution(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{3, 2, 8, 1, 7, 4, 5, 6})); // Answer : 11
    }
}