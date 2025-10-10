package javamistakes;

/*
    수치 오버플로
    - 컴퓨터는 연산 속도를 높이기 위해 기본적으로 모든 숫자에 고정된 수의 비트를 할당한다.
      하지만 값에 할당된 메모리 영역과 연산 결과의 비트 크기가 들어맞지 않으면 수치 오버플로가 발생한다.

    - 결과를 담는 변수가 Long 타입일지라도, int 타입의 연산으로 진행된다면 오버플로가 발생할 수 있다.
      --> 연산에 사용되는 피연산자 중 하나를 long으로 만들어서 명시적으로 long으로 캐스트를 한다.
 */
public class Ex027_NumericOverflow {

    public static void main(String[] args) {
        // 2,147초 까지는 정상적으로 동작.
        long microsecond = toMicrosecond(2_147);
        System.out.println(microsecond); // 2147000000

        // 2,147초가 넘어가면 오작동.
        // 계산결과를 Long 변수에 할당하더라도 곱셈은 int 타입으로 수행되기 때문.
        microsecond = toMicrosecond(2_148);
        System.out.println(microsecond); // -2146967296 (오동작)

        // 버그 수정
        microsecond = toMicrosecondWithLongType(2_148);
        System.out.println(microsecond); // 2148000000 (정상수행)
    }

    public static long toMicrosecond(int second) {
        long microsecond = second * 1_000_000;
        return microsecond;
    }

    public static long toMicrosecondWithLongType(int second) {
        long microsecond = second * 1_000_000L; // L 접미사를 붙여 명시적으로 long으로 곱셈을 진행한다.
        return microsecond;
    }

}
