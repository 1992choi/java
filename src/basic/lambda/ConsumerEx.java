package basic.lambda;

import java.text.DecimalFormat;
import java.util.function.*;

// Consumer는 매개값을 소비하는 역할을 하는 함수형 인터페이스의 한 종류이다.
public class ConsumerEx {

    public static void main(String[] args) {
        // 한 개의 파라미터를 소비
        Consumer<String> consumer = s -> System.out.println(s + " World!");
        consumer.accept("Hello"); // Hello World!

        // 두 개의 파라미터를 소비
        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + " " + u);
        biConsumer.accept("Hello", "World!"); // Hello World!

        // double 값을 받아 소비
        DoubleConsumer doubleConsumer = d -> System.out.println("num : " + d);
        doubleConsumer.accept(10); // num : 10.0

        // 객체와 int 값을 받아 소비
        ObjIntConsumer<String> objIntConsumer = (t, u) -> System.out.println(t + u); // 객체, int 파라미터 소비
        objIntConsumer.accept("num : ", 10); // num : 10

        // int 값을 받아 소비(천 단위마다 콤마찍기 기능 추가)
        IntConsumer intConsumer =
                d -> {
                    DecimalFormat decFormat = new DecimalFormat("###,###");
                    System.out.println("num : " + decFormat.format(d));
                };
        intConsumer.accept(10000); // num : 10,000

    }

}
