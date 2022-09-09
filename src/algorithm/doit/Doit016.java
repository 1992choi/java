package algorithm.doit;

public class Doit016 {

    /*
        버블 소트 프로그램 1
          - C언어로 아래와 같은 소스가 작성되었으며,
            배열 arr이 주어질 때, 출력 값 구하기

            -------------- C로 작성된 코드 --------------
            bool changed = false;
            for (int i=1; i<=N+1; i++) {
                changed = false;ß
                for (int j=1; j<=N-i; j++) {
                    if (A[j] > A[j+1]) {
                        changed = true;
                        swap(A[j], A[j+1]);
                    }
                }
                if (changed == false) {
                    cout << i << '\n';
                    break;
                }
            }
     */
    static int solution(int[] arr) {
        boolean changed = false;
        int N = arr.length - 1;
        for (int i = 1; i <= N + 1; i++) {
            changed = false;
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    changed = true;
                }
            }
            if (changed == false) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{10, 1, 5, 2, 3})); // Answer : 3
        System.out.println("Answer : " + solution(new int[]{1, 3, 5, 7, 9})); // Answer : 1
    }
}