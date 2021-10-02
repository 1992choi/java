package basic.controlstatements;

import java.util.ArrayList;
import java.util.List;

public class Label {

    public static void main(String[] args) {
        List<String> list;

        // Label을 사용하지 않은 코드
        list = new ArrayList<>();
        boolean isContinue = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    isContinue = false;
                    break;
                }
                list.add(i + "_" + j);
            }
            if (!isContinue) {
                break;
            }
        }
        System.out.println(list); // [0_0, 0_1, 0_2, 0_3, 0_4, 1_0, 1_1, 1_2, 1_3, 1_4]

        // Label을 사용한 코드
        list = new ArrayList<>();
        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break outerLoop;
                }
                list.add(i + "_" + j);
            }
        }
        System.out.println(list); // [0_0, 0_1, 0_2, 0_3, 0_4, 1_0, 1_1, 1_2, 1_3, 1_4]
    }
}
