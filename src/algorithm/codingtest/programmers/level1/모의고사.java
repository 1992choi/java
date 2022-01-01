package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {

    public static int[] solution(int[] answers) {
        int[] stu1Pattern = {1, 2, 3, 4, 5};
        int[] stu2Pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] stuScore = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == stu1Pattern[i % 5]) {
                stuScore[0]++;
            }
            if (answers[i] == stu2Pattern[i % 8]) {
                stuScore[1]++;
            }
            if (answers[i] == stu3Pattern[i % 10]) {
                stuScore[2]++;
            }
        }

        int maxScore = Arrays.stream(stuScore).max().getAsInt();
        int[] answer = new int[(int) Arrays.stream(stuScore).filter(i -> i == maxScore).count()];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (stuScore[i] == maxScore) {
                answer[idx++] = i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }
}
