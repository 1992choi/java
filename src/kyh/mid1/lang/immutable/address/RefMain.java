package kyh.mid1.lang.immutable.address;

public class RefMain {

    public static void main(String[] args) {
        /*
            - 기본형과 참조형의 공유
              - 자바의 데이터 타입을 가장 크게 보면 기본형(Primitive Type)과 참조형(Reference Type)으로 나눌 수 있다.
              - 기본형: 하나의 값을 여러 변수에서 절대로 공유하지 않는다.
              - 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.
         */

        /*
            - 참조형 변수들은 같은 참조값을 통해 같은 인스턴스를 참조할 수 있다.
            - `b = a` 라고 하면 `a` 에 있는 참조값을 복사해서 `b` 에 전달한다.
            - 때문에 a와 b는 같은 참조값을 가지고 있다.
            - 이 때, b의 값을 변경하면 같은 참조값을 가지는 a도 같이 변경되는 것이다.
         */

        /*
            사이드 이펙트(Side Effect)는 프로그래밍에서 어떤 계산이 주된 작업 외에 추가적인 부수 효과를 일으키는 것을 말한다.
            위와 같이 b만 변경할 것을 예측하고 코드를 수정했는데, a까지 변경된 경우를 사이드 이펙트로 볼 수 있다.
            이를 해결하기 위해서는 처음부터 다른 인스턴스를 사용하도록 하면 된다.
            Ex) Address a = new Address("서울");
                Address b = new Address("서울");
         */

        Address a = new Address("서울");
        Address b = a;
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        change(b, "부산");
        System.out.println("a = " + a); // 부산
        System.out.println("b = " + b); // 부산
    }

    private static void change(Address address, String changeAddress) {
        System.out.println("주소 값을 변경합니다 -> " + changeAddress);
        address.setValue(changeAddress);
    }

}
