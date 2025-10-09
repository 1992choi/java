package javamistakes;

/*
    swtich문 통과 실수
    - switch문은 기본적으로 모든 분기를 차례대로 진행한다.
      그리고 종료하려면 break문을 명시적으로 써야한다. 만약 그렇지 않을 경우, 자바 특성에 의해서 이후 조건이 연이어서 실행된다.

    - 자바 14 이상이라면, 화살표(->) 방식을 사용한다.
      - 이는 자동으로 break 처리되므로, pass-through 문제가 발생하지 않는다.
 */
public class Ex017_SwitchPassThrough {

    public static void main(String[] args) {
        // 일반적인 switch문에서의 오류 발생 케이스.
        // 화요일~금요일까지 출력된다.
        int day = 2;

        switch (day) {
            case 1:
                System.out.println("월요일");
                // break; 누락
            case 2:
                System.out.println("화요일");
                // break; 누락
            case 3:
                System.out.println("수요일");
                // break; 누락
            case 4:
                System.out.println("목요일");
                // break; 누락
            case 5:
                System.out.println("금요일");
                // break; 누락
        }


        // 화살표 구문 사용한 케이스.
        // 화요일만 출력된다.
        day = 2;

        switch (day) {
            case 1 -> System.out.println("월요일");
            case 2 -> System.out.println("화요일");
            case 3 -> System.out.println("수요일");
            case 4 -> System.out.println("목요일");
            case 5 -> System.out.println("금요일");
        }
    }

}
