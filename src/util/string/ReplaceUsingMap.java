package util.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReplaceUsingMap {

    public static void main(String[] args) {
        String originValue = "";
        Map<String, String> map = new HashMap();
        map.put("code0", "코드0");
        map.put("code1", "코드1");
        map.put("code2", "코드2");
        map.put("code3", "코드3");
        map.put("code4", "코드4");
        map.put("code5", "코드5");

        /*** 변환 1. ***/
        // 변경 전
        originValue = "[code0 -> code1], [code2 -> code3], [code4 -> code5]";
        System.out.println(originValue); // [code0 -> code1], [code2 -> code3], [code4 -> code5]

        // 변경 후
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            originValue = originValue.replaceAll(key, map.get(key));
        }
        System.out.println(originValue); // [코드0 -> 코드1], [코드2 -> 코드3], [코드4 -> 코드5]


        /*** 변환 2. ***/
        // 변경 전
        originValue = "[code0 -> code1], [code2 -> code3], [code4 -> code5]";
        System.out.println(originValue); // [code0 -> code1], [code2 -> code3], [code4 -> code5]

        // 변경 후
        for (String key : map.keySet()) {
            originValue = originValue.replaceAll(key, map.get(key));
        }
        System.out.println(originValue); // [코드0 -> 코드1], [코드2 -> 코드3], [코드4 -> 코드5]
    }

}
