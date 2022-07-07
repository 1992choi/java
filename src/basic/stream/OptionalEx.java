package basic.stream;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {
        /*
            - Optional
              : Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다.
        */

        /* 1. 객체 생성하기 */
        String str = "aaa";
        Optional<String> opt1 = Optional.of(str);
        System.out.println(opt1); // Optional[aaa]
        System.out.println(opt1.get()); // aaa

        Optional<String> opt2 = Optional.of("bbb");
        System.out.println(opt2); // Optional[bbb]
        System.out.println(opt2.get()); // bbb

        // Optional<String> opt3 = Optional.of(null); // NPE 발생

        Optional<String> opt4 = Optional.ofNullable(null);
        System.out.println(opt4); // Optional.empty

        // Optional<String> nullOpt1 = null;
        Optional<String> nullOpt2 = Optional.empty(); // 초기화 값을 지정하지 않고 초기화할 경우, null 대신 Optional.empty() 권장



        /* 2. 객체 값 가져오기 */
        Optional<String> optVal1 = Optional.of("abc");
        Optional<String> optVal2 = null;
        Optional<String> optVal3 = Optional.empty();
        System.out.println(optVal1.get()); // abc
        // System.out.println(optVal2.get()); // 오류발생 : NullPointerException
        // System.out.println(optVal3.get()); // 오류발생 : NoSuchElementException

        // orElse : 값이 비어있으면 매개변수로 전달한 값을 반환한다.
        System.out.println(optVal1.orElse("zzz")); // abc
        // System.out.println(optVal2.orElse("zzz")); // 오류발생 : NullPointerException
        System.out.println(optVal3.orElse("zzz")); // zzz
    }

}
