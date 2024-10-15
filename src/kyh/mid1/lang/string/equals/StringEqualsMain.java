package kyh.mid1.lang.string.equals;

public class StringEqualsMain {

    public static void main(String[] args) {
        /*
            String 클래스 비교
            - 클래스 비교할 때는 == 비교가 아니라 항상 equals() 비교를 해야한다.
            - str3과 str4과 같이 문자열 리터럴을 사용하는 경우 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다.
              때문에 == 비교를해도 true가 나온다.
              하지만 isSame()과 같이 메서드를 분리해서 사용할 경우, isSame() 메서드 입장에서는 파라미터로 받는 String이 어떻게 생성되었는지 알 수 없으므로
              안전하게 equals() 비교를 하는 것이 좋다.
         */
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("new String() == 비교: " + (str1 == str2)); // false
        System.out.println("new String() equals 비교:" + (str1.equals(str2))); // true

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("리터럴 == 비교: " + (str3 == str4)); // true
        System.out.println("리터럴 equals 비교: " + (str3.equals(str4))); // true
    }

    private static boolean isSame(String x, String y) {
        // return x == y;
        return x.equals(y);
    }

}
