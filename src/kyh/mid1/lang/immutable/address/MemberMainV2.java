package kyh.mid1.lang.immutable.address;

public class MemberMainV2 {

    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        // 회원A, 회원B의 처음 주소는 모두 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 중간에 많은 코드가 삽입되고 있고, 시간이 한참 흐른 후에 아래와 같은 요구사항이 있다고 가정.
        // 불변객체를 사용할 경우, 값을 변경하면 안된다는 것을 명확하게 알 수 있다.

        // 회원B의 주소를 부산으로 변경해야함
        // memberB.getAddress().setValue("부산"); // 컴파일 오류
        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }

}
