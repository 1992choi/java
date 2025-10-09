package javamistakes;

/*
    잘못된 if-else 연쇄
    - 조건이 다양해질 경우, else if에서 else 키워드를 누락하기도 한다.
      이 경우, 만족하는 조건이 있음에도 예상과 다른 값이 할당되어 오류가 발생할 수 있다.

    - final 키워드를 사용하여 한 번만 할당됨이 보장되도록 처리할 수 있다.
    - switch 문을 사용하여 누락되는 문제를 해결할 수 있다.
 */
public class Ex015_IfWithoutElse {

    public static void main(String[] args) {
        // 일반적인 형태에서의 오류 발생 케이스
        int condition = 1;
        int value;

        if (condition == 1) {
            value = 1;
        } else if (condition == 2) {
            value = 2;
        } if (condition == 3) { // else 누락
            value = 3;
        } else {
            value = 4;
        }

        System.out.println(value); // 4. 중간에 else가 누락되어 최종적으로 4가 할당된 케이스.


        // final 키워드를 사용하여 오류를 사전에 검출하는 케이스
//        int condition2 = 1;
//        final int value2;
//
//        if (condition2 == 1) {
//            value2 = 1;
//        } else if (condition2 == 2) {
//            value2 = 2;
//        } if (condition2 == 3) { // else가 누락되면 컴파일오류가 발생하여, 바로 알아차릴 수 있다.
//            value2 = 3;
//        } else {
//            value2 = 4;
//        }


        int condition3 = 1;
        int value3;

        switch (condition3) {
            case 1 -> value3 = 1;
            case 2 -> value3 = 2;
            case 3 -> value3 = 3;
            default -> value3 = 4;
        }

        System.out.println(value3); // 1
    }

}
