package basic.generic;

class GenericMethd {
    public <T> T method1(T t) {
        return t;
    }

    public <K, V> void method2(K k, V v) {
        System.out.println(k + "=" + v);
    }
}

public class GenericMethod {

    public static void main(String[] args) {
        GenericMethd gm = new GenericMethd();

        String str = gm.method1("문자열");
        System.out.println("str : " + str); // str : 문자열
        int num = gm.method1(1);
        System.out.println("num : " + num); // num : 1

        gm.method2("사과", "1개"); // 사과=1개
        gm.method2("시력", 1.0); // 시력=1.0
        gm.method2(3, 3); // 3=3
    }

}
