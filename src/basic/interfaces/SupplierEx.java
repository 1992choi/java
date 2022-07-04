package basic.interfaces;

import java.util.Random;
import java.util.function.Supplier;

// 인자를 받지 않고 Type T를 리턴하는 함수형 인터페이스의 한 종류이다.
public class SupplierEx {

    public static void main(String[] args) {
        // 빈 문자인지 비교하여 제거
        Supplier<Integer> randomNumbers = () -> new Random().nextInt(10);
        System.out.println(randomNumbers.get()); // 0~9 사이의 랜덤한 값
    }

}
