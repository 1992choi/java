package basic.clazz;

public class BoxingAndUnboxing {

    public static void main(String[] args) {
        int n = 10;

        // 박싱
        Integer boxingNum = new Integer(n);
        System.out.println("boxingNum = " + boxingNum); // 10

        // 언박싱
        int unbonxingNum = boxingNum.intValue();
        System.out.println("unbonxingNum = " + unbonxingNum); // 10

        // 오토 박싱
        Integer autoBoxingNum = n;
        System.out.println("autoBoxingNum = " + autoBoxingNum); // 10

        // 오토 언박싱
        int autoUnbonxingNum = autoBoxingNum;
        System.out.println("autoUnbonxingNum = " + autoUnbonxingNum); // 10
    }

}
