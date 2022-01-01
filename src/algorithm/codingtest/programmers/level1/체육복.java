package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];

        for (int i = 0; i < student.length; i++) {
            student[i] = 1;
        }

        for (int i = 0; i < lost.length; i++) {
            student[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (student[0] == 2 && student[1] == 0) {
                    student[0]--;
                    student[1]++;
                }
            } else if (i == n - 1) {
                if (student[i] == 2 && student[i - 1] == 0) {
                    student[i]--;
                    student[i - 1]++;
                }
            } else {
                if (student[i] == 2 && student[i - 1] == 0) {
                    student[i]--;
                    student[i - 1]++;
                } else if (student[i] == 2 && student[i + 1] == 0) {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (student[i] > 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }
}
