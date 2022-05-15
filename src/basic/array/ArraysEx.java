package basic.array;

import java.util.Arrays;

public class ArraysEx {

    public static void main(String[] args) {
        String[] strArr = {"Z", "A", "B", "C", "D", "E"};

        // 값 출력
        System.out.println(strArr); // [Ljava.lang.String;@3fee733d : 주소값
        System.out.println(Arrays.toString(strArr)); // [Z, A, B, C, D, E] : 배열에 저장된 값

        // 값 복사
        String[] copyArr = Arrays.copyOfRange(strArr, 1, 3);
        System.out.println(Arrays.toString(copyArr)); // [A, B]

        // 값 정렬
        Arrays.sort(strArr); // 정렬
        System.out.println(Arrays.toString(strArr)); // [A, B, C, D, E, Z]

        // 2차원배열 내용 비교
        String[][] dimensionalArr1 = {
                {"A", "B"},
                {"C", "D"}
        };

        String[][] dimensionalArr2 = {
                {"A", "B"},
                {"C", "D"}
        };

        System.out.println(dimensionalArr1.equals(dimensionalArr2)); // false
        System.out.println(Arrays.deepEquals(dimensionalArr1, dimensionalArr2)); // true
    }

}
