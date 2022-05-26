package basic.etc;

/*
    Java7 이후 버전부터는 언더바(_)를 숫자 리터럴에 사용할 수 있게되어
    가독성을 향상시킬 수 있게 되었다.
*/
public class UnderscoresInNumeric {

    public static void main(String[] args) {
        int intNum = 10_000_000;
        System.out.println(intNum); // 10000000

        double doubleNum = 1_000_000.01;
        System.out.println(doubleNum); // 1000000.01
    }
}
