package basic.lambda;

import java.util.function.Supplier;

public class SupplierWithLazy {

    static boolean isLoggingEnabled = false;

    public static void main(String[] args) {
        /*
            메서드를 실행하여 실행결과를 로그로 출력하는 로직이 있다고 가정.
            - 로그가 활성화 되어있지 않다면, 로그를 찍을 수 없으니 비즈니스 로직이 동작하는게 불필요할 수 있다.
              즉시 평가의 경우 비즈니스 로직을 우선적으로 실행하기 때문에 리소스 낭비가 있을 수 있다.
              반면, 지연 평가는 비즈니스 로직을 미뤘다가 실제 사용될 때 호출이 되기 때문에 리소스 낭비를 막을 수 있다.
         */
        System.out.println("----------------------------");
        // 즉시 평가: getResult1()와 getResult2()가 먼저 실행됨.
        log(getResult1(), getResult2());

        System.out.println("----------------------------");
        // 지연 평가: Supplier 를 전달하고 내부에서 get() 호출 시점에만 평가됨. 즉 get이 호출되지 않았으니 비즈니스 로직 실행하지 않음.
        sumLazy(SupplierWithLazy::getResult1, SupplierWithLazy::getResult2);
    }

    private static void log(int a, int b) {
        if (isLoggingEnabled) {
            System.out.println("SUM = " + (a + b));
        }
    }

    private static void sumLazy(Supplier<Integer> a, Supplier<Integer> b) {
        if (isLoggingEnabled) {
            System.out.println("SUM = " + (a.get() + b.get()));
        }
    }

    private static int getResult1() {
        System.out.println("call getResult1()");
        return 100;
    }

    private static int getResult2() {
        System.out.println("call getResult2()");
        return 200;
    }

}
