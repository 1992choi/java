package basic.clazz.string;

public class StringEx {

    public static void main(String[] args) {
        // charAt() : 문자열의 n번째 문자를 반환한다.
        String str = "ABCDE";
        System.out.println(str.charAt(3)); // D

        // indexOf() : 특정 문자가 위치한 인덱스를 반환한다.(검색결과가 없는 경우 -1 반환)
        System.out.println(str.indexOf("BC")); // 1
        System.out.println(str.indexOf("G")); // -1

        // lastIndexOf() : 특정 문자가 위치한 마지막 인덱스를 반환한다.(검색결과가 없는 경우 -1 반환)
        str = "ABCDEBC";
        System.out.println(str.lastIndexOf("BC")); // 5
        System.out.println(str.lastIndexOf("G")); // -1

        // substring() : 특정 구간의 문자열을 반환한다.
        System.out.println(str.substring(3)); // DEBC : 3번째 인덱스의 문자부터 전부
        System.out.println(str.substring(3, 5)); // D : 3번째 인덱스의 문자부터 4번째 인덱스의 문자까지 -> (3 <= x < 5 : 마지막 인덱스는 포함하지 않음)

        // concat() : 문자열을 결합하여 반환한다.
        String strA = "abc";
        String strB = "zzz";
        System.out.println(strA.concat(strB)); // abczzz

        // startsWith() : 특정 문자열로 시작하는지 확인한다.
        str = "www.google.com";
        System.out.println(str.startsWith("www")); // true
        System.out.println(str.startsWith("www", 5)); // false (두 번째 파라미터를 통해 시작위치를 지정할 수 있다.)
        System.out.println(str.startsWith("google")); // false

        // endsWith() : 특정 문자열로 끝나는지 확인한다.
        str = "www.google.com";
        System.out.println(str.endsWith("com")); // true
        System.out.println(str.endsWith("google")); // false

        // toCharArray() : 문자열을 char배열로 반환한다.
        char[] ch = str.toCharArray();

        // toUpperCase() : 문자열을 대문자로 변경한다.
        // toLowerCase() : 문자열을 소문자로 변경한다.
        str = "Java";
        System.out.println(str.toUpperCase()); // JAVA
        System.out.println(str.toLowerCase()); // java

        // trim() : 문자열의 시작과 끝에 존재하는 공백을 제거한다.(중간에 위치해있는 공백은 제거하지 않는다.)
        str = "   J a v a   ";
        System.out.println(str.trim()); // J a v a

        // compareTo() : 문자열을 사전순서로 비교한다.(같으면 0, 이전 순서면 음수, 이후 순서면 양수를 반환한다.)
        str = "c";
        System.out.println(str.compareTo("a")); // 2 (c는 a보다 이후 문자이므로 양수 반환)
        System.out.println(str.compareTo("y")); // -22 (c는 y보다 이전 문자이므로 음수 반환)

        // equalsIgnoreCase() : 대소문자 구분없이 비교한다.
        str = "java";
        System.out.println(str.equals("JAVA")); // false
        System.out.println(str.equalsIgnoreCase("JAVA")); // true
    }

}
