package util.string;

import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {
        String pattern = "";


        System.out.println("===== 숫자만 허용 =====");
        pattern = "^[0-9]*$";
        System.out.println(Pattern.matches(pattern, "abc012")); // false
        System.out.println(Pattern.matches(pattern, "012")); // true
        System.out.println(Pattern.matches(pattern, "0 1 2")); // false


        System.out.println("===== 영문자만 허용 =====");
        pattern = "^[a-zA-Z]*$";
        System.out.println(Pattern.matches(pattern, "abc012")); // false
        System.out.println(Pattern.matches(pattern, "012")); // false
        System.out.println(Pattern.matches(pattern, "한글")); // false
        System.out.println(Pattern.matches(pattern, "abc")); // true
        System.out.println(Pattern.matches(pattern, "ABC")); // true
        System.out.println(Pattern.matches(pattern, "ABCd")); // true
        System.out.println(Pattern.matches(pattern, "A B c d")); // false


        System.out.println("===== 영문자 또는 숫자만 허용 =====");
        pattern = "^[a-zA-Z0-9]*$";
        System.out.println(Pattern.matches(pattern, "abc012")); // true
        System.out.println(Pattern.matches(pattern, "012")); // true
        System.out.println(Pattern.matches(pattern, "한글")); // false
        System.out.println(Pattern.matches(pattern, "abc")); // true
        System.out.println(Pattern.matches(pattern, "ABC")); // true
        System.out.println(Pattern.matches(pattern, "ABCd")); // true
        System.out.println(Pattern.matches(pattern, "A B c d")); // false


        System.out.println("===== 한글만 허용 =====");
        pattern = "^[가-힣]*$";
        System.out.println(Pattern.matches(pattern, "한글012")); // false
        System.out.println(Pattern.matches(pattern, "012")); // false
        System.out.println(Pattern.matches(pattern, "한글")); // true
        System.out.println(Pattern.matches(pattern, "ㄱㅏㄴㅏㄷㅏ")); // false
        System.out.println(Pattern.matches(pattern, "ㄱㅏ   ㄴㅏ   ㄷㅏ")); // false
        System.out.println(Pattern.matches(pattern, "abc")); // false


        System.out.println("===== 휴대폰 형식 =====");
        pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        System.out.println(Pattern.matches(pattern, "01012345678")); // false
        System.out.println(Pattern.matches(pattern, "010-1234-5678")); // true
        System.out.println(Pattern.matches(pattern, "010-123-4567")); // true
        System.out.println(Pattern.matches(pattern, "020-123-4567")); // false


        System.out.println("===== E-Mail 형식 =====");
        pattern = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        System.out.println(Pattern.matches(pattern, "test@google.com")); // true
        System.out.println(Pattern.matches(pattern, "test1@google.com")); // true
        System.out.println(Pattern.matches(pattern, "testgoogle.com")); // false
        System.out.println(Pattern.matches(pattern, "test@googlecom")); // false
        System.out.println(Pattern.matches(pattern, "abc")); // false


        System.out.println("===== 주민등록번호 형식 =====");
        pattern = "\\d{6}\\-[1-4]\\d{6}";
        System.out.println(Pattern.matches(pattern, "920731-1000000")); // true
        System.out.println(Pattern.matches(pattern, "920731-2000000")); // true
        System.out.println(Pattern.matches(pattern, "920731-3000000")); // true
        System.out.println(Pattern.matches(pattern, "920731-4000000")); // true
        System.out.println(Pattern.matches(pattern, "920731-5000000")); // false
        System.out.println(Pattern.matches(pattern, "9207311-1000000")); // false


        System.out.println("===== 파일확장자 형식 =====");
        pattern = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
        System.out.println(Pattern.matches(pattern, "test.txt")); // true
        System.out.println(Pattern.matches(pattern, "test.ppt")); // false
        System.out.println(Pattern.matches(pattern, "test.html")); // false
        System.out.println(Pattern.matches(pattern, "test.pdf")); // true


    }

}
