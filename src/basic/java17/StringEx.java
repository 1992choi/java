package basic.java17;

public class StringEx {

    public static void main(String[] args) {
        /*
            Text Blocks(멀티 라인 문자열)
            - 이전 버전의 Java에서는 멀티 라인 문자열을 처리하기 위해 여러 줄의 코드를 작성해야 했지만,
              Text Blocks를 사용하면 이를 단순화하고 가독성을 높일 수 있다.
         */

        String str = """
                Java 17의 Text Blocks를 사용하여,
                  멀티 라인 문자열을 쉽게 작성할 수 있다.
                    또한 들여쓰기와 줄바꿈이 자동으로 처리된다.
                """;

        System.out.println(str);
        // Java 17의 Text Blocks를 사용하여,
        //   멀티 라인 문자열을 쉽게 작성할 수 있다.
        //     또한 들여쓰기와 줄바꿈이 자동으로 처리된다.
    }

}
