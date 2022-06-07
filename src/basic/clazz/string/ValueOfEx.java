package basic.clazz.string;

public class ValueOfEx {

    public static void main(String[] args) {
        /*
            integer, double 등을 문자로 변환할 때,
            'String intStr = 123 + "";' 와 같은 형태로 사용할 수도 있지만, 가독성 및 성능을 위하여 String.valueOf()를 권장한다.
         */
        String intStr = String.valueOf(123);
        String doubleStr = String.valueOf(123.45);

        /*
            문자열을 숫자로 변경하기 위해서는
            Integer.parseInt(), Double.parseDouble() 등의 형태로 사용할 수 있다.
            또한 Integer.valueOf(), Double.valueOf()의 형태로 메서드명을 통일시켜 사용할 수도 있다.

            Integer.parseInt()와 Integer.valueOf()의 차이점
            - 리턴타입이 다르다.
              : parseInt()의 경우, 원시데이터인 int를 반환
              : valueOf()의 경우, 래퍼(Wrapper) 객체인 Integer를 반환
         */
        int intNum = Integer.parseInt("123");
        double doubleNum = Double.parseDouble("123.45");
        System.out.println(intNum); // 123
        System.out.println(doubleNum); // 123.45

        intNum = Integer.valueOf("123");
        doubleNum = Double.valueOf("123.45");
        System.out.println(intNum); // 123
        System.out.println(doubleNum); // 123.45
    }

}
