package kyh.mid1.lang.immutable.address;

public class RefMain2 {

    public static void main(String[] args) {
        /*
            앞서 발생한 사이드 이펙트는 공유하면 안되는 객체를 여러 변수에서 공유했기 때문에 발생한 문제이다.
            객체의 공유를 막을 수 없으니, 불변 객체를 도입함으로써 이를 해결할 수 있다.

            - 불변 객체
              - 객체의 상태(객체 내부의 값, 필드, 멤버 변수)가 변하지 않는 객체를 불변 객체(Immutable Object)라 한다.
              - 내부 값을 변경할 수 없도록 ImmutableAddress.value에 setter를 제거하였으며,
                근복적으로 수정할 수 없음을 나타내기 위해 final 키워드를 추가하였다.
         */
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a; // 참조값 대입을 막을 수 있는 방법이 없다.
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // b.setValue("부산"); // b의 값을 변경할 수 없으니 새로운 인스턴스를 만들도록 유도할 수 있다.
        b = new ImmutableAddress("부산");
        System.out.println("부산 -> b");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
