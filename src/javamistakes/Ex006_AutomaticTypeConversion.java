package javamistakes;

/*
    조건 표현식 또는 삼항 연산자에서 묵시적 타입 변환으로 인한 오류
    - mapValue()과 mapValue2()는 단순히 봤을 때는 동일한 결과를 반환한다.
      하지만 10보다 작은 숫자를 넘기면, mapValue()는 NPE가 발생한다.

      타입 결정 규칙에 의해서 차이가 생기는 것이다. : mapValue() 경우 최종적으로 언박싱에 의해서 원시타입 int로 변경되는데, null이 int로 변환되는 과정에서 오류가 발생하는 것이다.

    - 중첩 조건 표현식을 지양하고 if문으로 대체하여 가독성을 높이고, 오류 발생 여지를 제거한다.
 */
public class Ex006_AutomaticTypeConversion {

    public static void main(String[] args) {
        System.out.println(mapValue2(11)); // 1
        System.out.println(mapValue2(5)); // null

        System.out.println(mapValue(11)); // 1
        System.out.println(mapValue(5)); // NPE
    }

    private static Integer mapValue(int input) {
        return input > 20 ? 2 : input > 10 ? 1 : null;
    }

    private static Integer mapValue2(int input) {
        return input <= 10 ? null : input <= 20 ? 1 : 2;
    }

}
