package fastcampus.stream.part4;

import java.util.function.Supplier;

public class SupplierEx {

    public static void main(String[] args) {
        /*
            Supplier
            - 공급자
            - input없이 return 값만 존재하는 함수이다.
         */

        // 예제 1. "hello world!"을 리턴하는 함수
        Supplier<String> myStringSupplier = () -> "hello world!";
        System.out.println(myStringSupplier.get()); // hello world!

        // 예제 2. 랜덤값을 반환하는 함수
        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get()); // 랜덤값 출력
        System.out.println(myRandomDoubleSupplier.get()); // 랜덤값 출력

        // 함수가 1등 시민이 되었기 때문에 함수 자체를 파라미터로 넘길 수도 있다.
        printRandomDoubles(myRandomDoubleSupplier, 3); // 랜덤값 출력
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get()); // 랜덤값 출력
        }
    }

}
