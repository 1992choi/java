package basic.clazz;

import java.util.*;
import static java.lang.Math.random;

public class Import {

    public static void main(String[] args) {
        /*
            List와 ArrayList를 사용할 경우, 아래와 같이 import문을 작성하지 않고,
            'import java.util.*;'와 같이 와일드카드를 사용하더라도 런타임 속도에는 영향을 미치지 않는다.
                - import java.util.ArrayList;
                - import java.util.List;

                * 단, 컴파일 단계에서는 영향을 줄 수는 있다.
                * 컴파일된 class파일을 디컴파일하면 와일드카드가 아닌 'import java.util.ArrayList;'와 'import java.util.List;'로 작성되어 있다.
         */
        List<String> list = new ArrayList<>();



        /*
            static import문을 사용(import static java.lang.Math.random;)할 경우,
            클래스 이름을 생략할 수 있다.

         */
        System.out.println(Math.random()); // 일반적인 사용 예시
        System.out.println(random()); // static import문을 사용하여 Math를 생략한 케이스
    }

}
