package algorithm.doit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Doit009 {

    /*
        DNA 비밀번호
        : DNA 문자열이란 주어진 모든 문자열이 'A', 'C', 'G', 'T'로 이루어진 문자열을 말한다.
          DNA 문자열로 길이가 n인 비밀번호를 만들 때, 다음과 같은 조건이 주어질 때 만들 수 있는 비밀번호의 갯수

          - 조건 1. 길이가 4인 숫자 배열 nums가 주어질 때, 각 각의 숫자는 최소로 포함되어야하는 문자의 갯수를 나타낸다.
                   Ex) nums={2, 0, 1, 1} => DNA문자열에 A가 최소 2개, C가 최소 0개, G가 최수 1개, T가 최소 1개가 되어야한다.
          - 조건 2. 같은 알파벳으로 구성되어있더라도 순서가 다르면 다른 패스워드로 간주한다.
                   Ex) ACCG != AGCC

        dnaStr = DNA문자열
        nums = 최소 포함되어야하는 문자의 수
        length = 패스워드 비밀번호
     */
    static int solution(String dnaStr, int[] nums, int n) {
        Set<String> passwordSet = new HashSet<>();

        for (int i = 0; i < dnaStr.length(); i++) {
            String password = String.valueOf(dnaStr.charAt(i));
            for (int j = 0; j < dnaStr.length(); j++) {
                if (i == j || password.length() >= n) { // 자기 자신과의 조합 || 비밀번호 길이 초과하였을 경우
                    continue;
                }

                password += String.valueOf(dnaStr.charAt(j));
                if (password.length() == n) {
                    int aCnt = 0;
                    int cCnt = 0;
                    int gCnt = 0;
                    int tCnt = 0;
                    for (int k = 0; k < n; k++) {
                        if (password.charAt(k) == 'A') {
                            aCnt++;
                        } else if (password.charAt(k) == 'C') {
                            cCnt++;
                        } else if (password.charAt(k) == 'G') {
                            gCnt++;
                        } else if (password.charAt(k) == 'T') {
                            tCnt++;
                        }
                    }

                    if (aCnt >= nums[0] && cCnt >= nums[1] && gCnt >= nums[2] && tCnt >= nums[3]) {
                        passwordSet.add(password);
                    } else {
                        password = String.valueOf(dnaStr.charAt(i));
                    }
                }

            }
        }

        System.out.println(passwordSet);
        return passwordSet.size();
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution("CCTGGATTG", new int[]{2, 0, 1, 1}, 8));
        System.out.println("Answer : " + solution("GATA", new int[]{1, 0, 0, 1}, 2));
    }
}