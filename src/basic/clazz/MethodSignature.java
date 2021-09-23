package basic.clazz;

/**
 * <pre>
 * 메서드 시그니쳐란?
 *
 * 컴파일러는 메서드의 시그니처를 이용하여 메서드를 구분한다.
 * 메서드의 이름과 파라미터를 메서드 시그니처라고 하며, 리턴 타입은 포함되지 않는다.
 * </pre>
 */
public class MethodSignature {

    public static void print(int val) {
        System.out.println(val);
    }

    /*
        메서드 시그니처에 리턴 타입은 포함되지 않는다.

        public static int print(int val) {
            System.out.println(val);
            return val;
        }
    */

    public static void print(int val1, int val2) {
        System.out.println(val1 + ", " + val2);
    }

    public static void print(double val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        print(1);
        print(1, 2);
        print(3.4);
    }

}
