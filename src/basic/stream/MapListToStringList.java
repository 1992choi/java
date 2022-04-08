package basic.stream;

import java.util.*;
import java.util.stream.Collectors;

public class MapListToStringList {

    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();

        // 데이터 생성
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(i));
            map.put("phone", "010-1234-000" + i);

            mapList.add(map);
        }
        System.out.println(mapList); // [{phone=010-1234-0000, id=0}, {phone=010-1234-0001, id=1}, {phone=010-1234-0002, id=2}, {phone=010-1234-0003, id=3}, {phone=010-1234-0004, id=4}, {phone=010-1234-0005, id=5}, {phone=010-1234-0006, id=6}, {phone=010-1234-0007, id=7}, {phone=010-1234-0008, id=8}, {phone=010-1234-0009, id=9}]

        // 특정 값만 추출 : List<Map> -> List<String>
        List<String> stringList = mapList.stream().map(s -> s.get("phone")).collect(Collectors.toList());
        System.out.println(stringList); // [010-1234-0000, 010-1234-0001, 010-1234-0002, 010-1234-0003, 010-1234-0004, 010-1234-0005, 010-1234-0006, 010-1234-0007, 010-1234-0008, 010-1234-0009]
    }

}
