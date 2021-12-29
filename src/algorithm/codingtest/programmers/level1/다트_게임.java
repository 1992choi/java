package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/17682
public class 다트_게임 {

    public static int solution(String dartResult) {
        int[] roundScore = {0, 0, 0};
        Object[] score = Arrays.stream(dartResult.split("[^0-9]")).filter(s -> !"".equals(s)).toArray();
        Object[] bonusAndOpt = Arrays.stream(dartResult.split("[0-9]")).filter(s -> !"".equals(s)).toArray();

        for (int i = 0; i < 3; i++) {
            // 라운드별 결과 추출
            int currentScore = Integer.parseInt((String)score[i]);
            char currentBonus = ((String)bonusAndOpt[i]).charAt(0);
            char currentOpt = ' ';
            if (((String)bonusAndOpt[i]).length() == 2) {
                currentOpt = ((String)bonusAndOpt[i]).charAt(1);
            }

            // 결과 합산
            if (currentBonus == 'D') {
                currentScore = (int)Math.pow(currentScore, 2);
            } else if (currentBonus == 'T') {
                currentScore = (int)Math.pow(currentScore, 3);
            }

            if (currentOpt == '*') {
                currentScore *= 2;
                if (i != 0) {
                    roundScore[i - 1] = roundScore[i - 1] * 2;
                }
            } else if (currentOpt == '#') {
                currentScore *= -1;
            }

            roundScore[i] = currentScore;
        }

        return Arrays.stream(roundScore).sum();
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }
}
