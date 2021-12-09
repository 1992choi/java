package basic.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EmptyListTest {

    public static void main(String[] args) {
        List<String> list = null;
        String accessIp = "10.1.0.107";
        boolean isBlockedIp = false;

        // 1. list가 null인 경우
        /* 오류 발생
            isBlockedIp = list.stream().filter(ip -> accessIp.indexOf(ip) > -1).count() > 0 ? true : false;
            System.out.println(isBlockedIp);
        */



        // 2. list의 값이 없는 경우
        System.out.println("2. list의 값이 없는 경우");
        list = new ArrayList<>();
        isBlockedIp = list.stream().filter(ip -> accessIp.indexOf(ip) > -1).count() > 0 ? true : false;
        System.out.println(isBlockedIp); // false

        list = Arrays.asList();
        isBlockedIp = list.stream().filter(ip -> accessIp.indexOf(ip) > -1).count() > 0 ? true : false;
        System.out.println(isBlockedIp); // false

        list = Arrays.asList("");
        isBlockedIp = list.stream().filter(ip -> accessIp.indexOf(ip) > -1).count() > 0 ? true : false;
        System.out.println(isBlockedIp); // true

        list = Arrays.asList("");
        isBlockedIp = list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0 ? true : false;
        System.out.println(isBlockedIp); // false



        // 3. list의 값이 있는 경우
        System.out.println("3. list의 값이 있는 경우");
        list = Arrays.asList("11.1.1.107", "11.1.1.", "11.1");
        isBlockedIp = list != null
                && (list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0) ? true : false;
        System.out.println(isBlockedIp); // false

        list = Arrays.asList("10.1.0.107", "11.1.1.", "11.1");
        isBlockedIp = list != null
                && (list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0) ? true : false;
        System.out.println(isBlockedIp); // true

        list = Arrays.asList("10.1.0.108", "10.1.0.", "11.1");
        isBlockedIp = list != null
                && (list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0) ? true : false;
        System.out.println(isBlockedIp); // true

        list = Arrays.asList("10.1.0.108", "11.1.1.", "10.1");
        isBlockedIp = list != null
                && (list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0) ? true : false;
        System.out.println(isBlockedIp); // true

        list = Arrays.asList("10.1.0.107");
        isBlockedIp = list != null
                && (list.stream().filter(ip -> !"".equals(ip) && accessIp.indexOf(ip) > -1).count() > 0) ? true : false;
        System.out.println(isBlockedIp); // true

    }

}
