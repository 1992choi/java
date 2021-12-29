package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);

            wMax = Math.max(wMax, width);
            hMax = Math.max(hMax, height);
        }

        return wMax * hMax;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
