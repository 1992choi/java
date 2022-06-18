package basic.clazz.string;

public class StringBufferEx {

    public static void main(String[] args) {
        /*
            StringBuffer 특징
            - String클래스와 다르게 값을 변경할 수 있다.(String은 불변 객체)
            - String클래스와 달리 equals()를 오버라이딩하지 않았다.
            - StringBuilder(동기화를 지원x)와 다르게 동기화를 지원하여 멀티쓰레드 환경에서 안전하다.(Thread-safe)
              * String클래스는 불변 객체이기 때문에 Thread-safe.
         */

        /*
            버퍼의 크기를 지정해주지 않으면 기본적으로 16개의 문자를 지정할 수 있는 크기의 버퍼를 생성한다.
            사이즈를 초과할 경우, 재할당을 하게되어 성능을 저하시킬 수 있기 때문에 데이터를 고려해서 버퍼를 지정해야 한다.
         */
        // StringBuffer sb = new StringBuffer();
        StringBuffer sb = new StringBuffer(100);

        // append() : 문자열을 결합한다.
        sb = new StringBuffer("abc");
        sb.append("de");
        System.out.println(sb); // abcde

        // insert() : 특정 위치에 문자열을 삽입힌다.
        sb = new StringBuffer("abc");
        sb.insert(0, "123");
        System.out.println(sb); // 123abc

        // delete() : 특정 범위의 문자열을 제거한다.
        sb = new StringBuffer("abcde");
        sb.delete(2, 4);
        System.out.println(sb); // abe

        // deleteCharAt() : 특정 위치의 문자열을 제거한다.
        sb = new StringBuffer("abcde");
        sb.deleteCharAt(3);
        System.out.println(sb); // abce

        // reverse() : 문자열의 순서를 뒤집는다.
        sb = new StringBuffer("abcde");
        sb.reverse();
        System.out.println(sb); // edcba

        // equals() : StringBuffer는 String클래스와 달리 equals()를 오버라이딩하지 않았다.
        String strA = new String("abc");
        String strB = new String("abc");
        System.out.println(strA.equals(strB)); // true

        StringBuffer sbA = new StringBuffer("abc");
        StringBuffer sbB = new StringBuffer("abc");
        System.out.println(sbA.equals(sbB)); // false

    }

}
