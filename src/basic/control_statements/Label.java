package basic.control_statements;

import java.util.ArrayList;
import java.util.List;

public class Label {

    public static void main(String[] args) {
        List<Integer> list;

        // Label을 사용하지 않은 코드
        list = new ArrayList<>();
        boolean isContinue = true;
        for (int i = 0; i < 5; i++) {
            list.add(i);
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    isContinue = false;
                }
            }
            if (!isContinue) {
                break;
            }
        }
        System.out.println(list); // 0, 1, 2

        // Label을 사용한 코드
        list = new ArrayList<>();
        outerLoop:
        for (int i = 0; i < 5; i++) {
            list.add(i);
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break outerLoop;
                }
            }
        }
        System.out.println(list); // 0, 1, 2
    }
}
