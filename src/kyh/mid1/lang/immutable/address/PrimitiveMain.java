package kyh.mid1.lang.immutable.address;

public class PrimitiveMain {

    public static void main(String[] args) {
        /*
            - 기본형과 참조형의 공유
              - 자바의 데이터 타입을 가장 크게 보면 기본형(Primitive Type)과 참조형(Reference Type)으로 나눌 수 있다.
              - 기본형: 하나의 값을 여러 변수에서 절대로 공유하지 않는다.
              - 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.
         */

        /*
            - 기본형은 절대로 같은 값을 공유하지 않는다.
            - 기본형 변수 `a` 와 `b` 는 절대로 하나의 값을 공유하지 않는다.
            - `b = a` 라고 하면 자바는 항상 값을 복사해서 대입한다.
            - 결과적으로 a와 b는 모두 10이라는 똑같은 숫자를 가지지만,
              메모리상 각각 별도로 존재하기 때문에, b의 값을 바꿔도 a에는 영향이 없다.
         */
        int a = 10;
        int b = a; // a -> b, 값 복사 후 대입
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 10

        b = 20;
        System.out.println("20 -> b");
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20
    }

}
