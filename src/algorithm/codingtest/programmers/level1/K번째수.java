package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tmp;

        for (int i = 0; i < commands.length; i++) {
            tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
