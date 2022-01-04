package algorithm.codingtest.programmers.level2;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class 오픈채팅방 {

    public static String[] solution(String[] record) {
        Map<String, String> user = new HashMap();
        for (int i = 0; i < record.length; i++) {
            String action = record[i].split(" ")[0];
            if ("Enter".equals(action) || "Change".equals(action)) {
                String uid = record[i].split(" ")[1];
                String name = record[i].split(" ")[2];
                user.put(uid, name);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String action = record[i].split(" ")[0];
            String uid = record[i].split(" ")[1];
            if ("Enter".equals(action)) {
                list.add(user.get(uid) + "님이 들어왔습니다.");
            } else if ("Leave".equals(action)) {
                list.add(user.get(uid) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"})));
    }
}
