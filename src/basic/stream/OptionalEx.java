package basic.stream;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {
        /*
            - Optional
              : Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다.
        */

        /* 1. 객체 생성하기 */
        System.out.println("=== 1. 객체 생성하기 ===");
        Optional<String> opt1 = Optional.of("aaa");
        System.out.println(opt1); // Optional[aaa]
        System.out.println(opt1.get()); // aaa

        Optional<String> opt2 = Optional.of("bbb");
        System.out.println(opt2); // Optional[bbb]
        System.out.println(opt2.get()); // bbb

        // Optional<String> opt3 = Optional.of(null); // NPE 발생

        Optional<String> opt4 = Optional.ofNullable(null);
        System.out.println(opt4); // Optional.empty
        // System.out.println(opt4.get()); // NoSuchElementException 발생

        // Optional<String> nullOpt1 = null;
        Optional<String> nullOpt2 = Optional.empty(); // 초기화 값을 지정하지 않고 초기화할 경우, null 대신 Optional.empty() 권장



        /* 2. NULL 여부 판단 */
        System.out.println("=== 2. NULL 여부 판단 ===");
        Optional<String> optNull1 = Optional.ofNullable("ABC");
        System.out.println(optNull1.isPresent()); // true
        System.out.println(optNull1.isEmpty()); // false

        Optional<String> optNull2 = Optional.ofNullable(null);
        System.out.println(optNull2.isPresent()); // false
        System.out.println(optNull2.isEmpty()); // true



        /* 3. 값 가져오기 */
        System.out.println("=== 3. 값 가져오기 ===");
        String nullStr = null;
        String notNullStr = "ABC";

        // System.out.println(Optional.ofNullable(nullStr).get()); // NoSuchElementException 발생
        System.out.println(Optional.ofNullable(notNullStr).get()); // ABC

        System.out.println(Optional.ofNullable(nullStr).orElse("XYZ")); // XYZ
        System.out.println(Optional.ofNullable(notNullStr).orElse("XYZ")); // ABC

        System.out.println(Optional.ofNullable(nullStr).orElseGet(() -> "XYZ")); // XYZ
        System.out.println(Optional.ofNullable(notNullStr).orElseGet(() -> "XYZ")); // ABC



        /* 4. orElse()와 orElseGet()의 차이 */
        System.out.println("=== 4. orElse()와 orElseGet()의 차이  ===");
        System.out.println(Optional.ofNullable(nullStr).orElse(getDefaultValue()));
        /* - 실행결과
         *   # getDefaultValue() 실행
         *   default
         */

        System.out.println(Optional.ofNullable(notNullStr).orElse(getDefaultValue()));
        /* - 실행결과 (NULL이 아닌데도 getDefaultValue()가 수행된다.)
         *   # getDefaultValue() 실행
         *   ABC
         */

        System.out.println(Optional.ofNullable(nullStr).orElseGet(OptionalEx::getDefaultValue));
        /* - 실행결과
         *   # getDefaultValue() 실행
         *   default
         */

        System.out.println(Optional.ofNullable(notNullStr).orElseGet(OptionalEx::getDefaultValue));
        /* - 실행결과 (NULL이 아니어서 getDefaultValue()가 수행되지 않았다.)
         *   ABC
         */



        /* 5. 예외 발생시키기 */
        String userName = "CHOI";
        String userNullName = null;
        System.out.println(Optional.ofNullable(userName).orElseThrow(IllegalArgumentException::new)); // CHOI
        System.out.println(Optional.ofNullable(userNullName).orElseThrow(IllegalArgumentException::new)); // IllegalArgumentException 발생

        if (userName == null) {
            throw new IllegalArgumentException();
        }
    }

    static String getDefaultValue() {
        System.out.println("# getDefaultValue() 실행");
        return "default";
    }

}
