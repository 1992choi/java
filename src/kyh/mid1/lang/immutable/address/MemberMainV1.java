package kyh.mid1.lang.immutable.address;

public class MemberMainV1 {

    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        // 회원A, 회원B의 처음 주소는 모두 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 중간에 많은 코드가 삽입되고 있고, 시간이 한참 흐른 후에 아래와 같은 요구사항이 있다고 가정.
        // 가변객체를 사용할 경우, 이전 코드를 고려하지 않고 setter를 활용해서 값을 변경할 여지가 있다.

        // 회원B의 주소를 부산으로 변경해야함
        memberB.getAddress().setValue("부산");
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }

}
