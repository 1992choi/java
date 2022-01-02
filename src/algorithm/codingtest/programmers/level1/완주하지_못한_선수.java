package algorithm.codingtest.programmers.level1;

import java.util.HashMap;
import java.util.Iterator;

// https://programmers.co.kr/learn/courses/30/lessons/42576
public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int mapCheckCnt = 0;
        for (int i = 0; i < participant.length; i++) {
            mapCheckCnt = map.get(participant[i]) == null ? 0 : map.get(participant[i]);
            map.put(participant[i], ++mapCheckCnt);
        }

        for (int i = 0; i < completion.length; i++) {
            mapCheckCnt = map.get(completion[i]) == null ? 0 : map.get(completion[i]);
            map.put(completion[i], --mapCheckCnt);
        }

        Iterator<String> keys = map.keySet().iterator();
        String key;
        while (keys.hasNext()) {
            key = keys.next();
            if (map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
