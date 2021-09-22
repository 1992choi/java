package basic.operator;

/**
 * <pre>
 * 쇼트 서킷이란?
 *
 * 연산을 수행하는 과정에서 결과가 이미 확정되었을 때,
 * 나머지 연산 과정을 생략하는 것을 뜻한다.
 *
 * 논리 연산자 - 쇼트 서킷 적용o
 * 비트 연산자 - 쇼트 서킷 적용x
 * </pre>
 */
public class ShortCircuit {

    public static void main(String[] args) {
        int a;
        int b;

        // 논리 연산자
        a = 1;
        b = 1;
        System.out.println(false && a++ > 5); // a++ > 5 연산 생략
        System.out.println(true || b++ > 5); // b++ > 5 연산 생략
        System.out.println(a); // 1
        System.out.println(b); // 1

        // 비트 연산자
        a = 1;
        b = 1;
        System.out.println(false & a++ > 5); // a++ > 5 연산 생략안함
        System.out.println(true | b++ > 5); // b++ > 5 연산 생략안함
        System.out.println(a); // 2
        System.out.println(b); // 2
    }

}
