package algorithm.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://programmers.co.kr/learn/courses/30/lessons/12915
public class 문자열_내_마음대로_정렬하기 {

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        /* n번째 문자를 제일 앞으로 가져와서 정렬 */

        // 1. n번째 문자 추가하기
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            array.add(strings[i].charAt(n) + strings[i]);
        }

        // 2. 정렬
        Collections.sort(array);

        // 3. 추가한 문자 제거
        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
