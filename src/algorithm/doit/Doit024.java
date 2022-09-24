package algorithm.doit;

import java.util.ArrayList;
import java.util.List;

public class Doit024 {

    /*
        신기한 소수 찾기
          - N의 자리 숫자 중 신기한 소수 찾기
            * 신기한 소수
              : Ex) 7331이라는 소수가 주어졌을 때,
                    왼쪽부터 1자리, 2자리, 3자리, 4자리인
                    7, 73, 733, 7331이 모두 소수인 수

     */
    static List<Integer> solution(int n) {
        List<Integer> primeList = new ArrayList<>();
        List<Integer> removeList = new ArrayList<>();

        int startRange = (int)Math.pow(10, n - 1) * 2;
        int endRange = (int)Math.pow(10, n) - 1;

        // 1. 소수 구하기
        for (int i = startRange; i <= endRange; i++) {
            int cnt = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                primeList.add(i);
            }
        }

        // 2. 신기한 소수 구하기
        for (int i = 0; i < primeList.size(); i++) {
            for (int idx = 0; idx < n; idx++) {
                int num = Integer.parseInt(String.valueOf(primeList.get(i)).substring(0, (idx + 1)));
                int cnt = 0;
                for (int j = 2; j <= num; j++) {
                    if (num % j == 0) {
                        cnt++;
                    }
                }

                if (cnt != 1) {
                    removeList.add(primeList.get(i));
                    break;
                }
            }
        }

        // 3. 신기한 소수가 아닌 소수 제거하기
        for (int i = 0; i < removeList.size(); i++) {
            primeList.remove(new Integer(removeList.get(i)));
        }

        return primeList;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
        // [23, 29, 31, 37, 53, 59, 71, 73, 79]

        System.out.println(solution(3));
        // [233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797]

        System.out.println(solution(4));
        // [2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393]
    }
}