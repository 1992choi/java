package basic.java17;

public class SwitchEx {

    public static void main(String[] args) {
        /*
            Pattern Matching for switch (스위치 패턴 매칭)
            - Switch 문에서 패턴 매칭을 사용하여 다양한 조건을 처리할 수 있다.
            - 람다 구문의 사용과 값을 반환하는 것이 가능해졌다.
         */

        int num = 3;

        String mappedNum = switch (num) {
            case 1 -> "1";
            case 2, 3, 4 -> "2~4";
            default -> "-";
        };

        System.out.println(mappedNum); // 2~3
    }

}
