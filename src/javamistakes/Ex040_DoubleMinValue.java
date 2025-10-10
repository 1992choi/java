package javamistakes;

/*
    Double.MIN_VALUE는 최솟값이 아니다.
    - 일부 알고리즘은 최솟값과 최댓값이 필요하다.
      int에서는 Integer.MIN_VALUE와 MAX_VALUE를 사용한다. (long도 마찬가지)
      하지만 Double의 경우 그렇지가 않다.
      Double.MIN_VALUE는 double 타입으로 표현할 수 있는 가장 작은 '양수' 값이다.
      최솟값을 나타내는 명시적 상수는 없지만 꼭 필요한 경우라면 -Double.MAX_VALUE를 사용하면 된다.
 */
public class Ex040_DoubleMinValue {

    public static void main(String[] args) {
        double[] numbers = {-10.5, -3.2, -7.8};

        // 오동작 (Double.MIN_VALUE 사용)
        System.out.println(max(numbers)); // 4.9E-324

        // 정상동작 (-Double.MAX_VALUE 사용)
        System.out.println(max2(numbers)); // -3.2
    }

    public static double max(double... data) {
        double max = Double.MIN_VALUE; // Double.MIN_VALUE는 음수가 아니라, 가장 작은 양수
        for (double d : data) {
            max = Math.max(max, d);
        }

        return max;
    }

    public static double max2(double... data) {
        double max = -Double.MAX_VALUE;
        for (double d : data) {
            max = Math.max(max, d);
        }

        return max;
    }

}
