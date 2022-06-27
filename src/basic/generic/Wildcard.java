package basic.generic;

import java.util.ArrayList;
import java.util.List;

class Fruit {}

class Banana extends Fruit {}

class Melon extends Fruit {}

class Keyboard {}

public class Wildcard {

    public static void main(String[] args) {
        /*
            * 와일드카드
              : 와일드카드는 제네릭 타입을 매개 값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에 사용하는 것으로 코드에서는 ?로 표현된다.

            1. <?> (Unbound WildCard, 제한 없음)
                : 제한없이 모든 타입이 가능하다.
            2. <? super 하위타입> (Lower Bounded Wildcard, 하위 클래스로 제한)
                : 하위 타입만 사용 가능하다.
            3. <? extends 상위타입> (Upper Bounded Wildcard, 상위 클래스로 제한)
                : 상위 타입만 사용 가능하다.
        */



        // 1. <?> (제한 없음)
        List<?> all1 = new ArrayList<Fruit>();
        List<?> all2 = new ArrayList<Banana>();
        List<?> all3 = new ArrayList<Melon>();
        List<?> all4 = new ArrayList<Keyboard>();



        // 2. <? super 하위타입> (상위 클래스로 제한)
        List<? super Banana> bananas1 = new ArrayList<Banana>();
        List<? super Banana> bananas2 = new ArrayList<Fruit>();
//        List<? super Banana> bananas3 = new ArrayList<Melon>(); // 오류 발생



        // 3. <? extends 상위타입> (하위 클래스로 제한)
//        List<Fruit> bananas = new ArrayList<Banana>(); // 오류 발생
//        List<Fruit> melons = new ArrayList<Melon>(); // 오류 발생
        List<? extends Fruit> fruits1 = new ArrayList<Fruit>();
        List<? extends Fruit> fruits2 = new ArrayList<Banana>();
        List<? extends Fruit> fruits3 = new ArrayList<Melon>();
//        List<? extends Fruit> fruits4 = new ArrayList<Keyboard>(); // 오류 발생
    }

}
