package basic.generic;

class GenericMethd2 {
    /*
        GenericMethod.java의 GenericMethd 클래스에서 메서드의 타입 제한을 위하여 extends 키워드를 추가하였다.
     */
    public <T extends String> T method1(T t) {
        return t;
    }
    public <K, V extends Number> void method2(K k, V v) {
        System.out.println(k + "=" + v);
    }
}

public class TypeRestrictOnMethod {

    public static void main(String[] args) {
        GenericMethd2 gm2 = new GenericMethd2();

        String str = gm2.method1("문자열");
        System.out.println("str : " + str);
        /* 메서드의 타입이 String으로 제한되어 숫자 타입은 사용하지 못하게 되었다.
            int num = gm2.method1(1);
            System.out.println("num : " + num);
         */

        /*
            메서드의 두 번째 파라미터 타입이 Number로 제한되어 문자열 타입은 사용하지 못하게 되었다.
            gm2.method2("사과", "1개");
        */
        gm2.method2("시력", 1.0);
        gm2.method2(3, 3);
    }

}
