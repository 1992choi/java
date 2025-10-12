package javamistakes;

import java.math.BigDecimal;

/*
    BigDecimal.equals()
    - BigDecimal은 언스케일 값(BigInteger)와 스케일 값(int)을 담고 있다.
    - BigDecimal의 equals()는 최종 숫자와는 무관하게 언스케일과 스케일 값을 각각 비교한다.
    - 때문에 BigDecimal을 제대로 비교하고 싶다면 compareTo()를 이용하는 것이 좋다.
 */
public class Ex058_BigDecimalEquals {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("10.0");

        System.out.println(a.equals(b)); // false
        System.out.println(a.compareTo(b)); // 0 (같음)
    }

}
