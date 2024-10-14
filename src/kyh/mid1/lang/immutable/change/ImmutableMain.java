package kyh.mid1.lang.immutable.change;

public class ImmutableMain {

    public static void main(String[] args) {
        /*
            - 불변 객체의 값 변경
              - 불변 객체를 설계할 때 기존 값을 변경해야 하는 메서드가 필요할 수 있다.
                이때는 기존 객체의 값을 그대로 두고 대신에 변경된 결과를 새로운 객체에 담아서 반환하면 된다.
         */
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20);

        // 계산 이후에도 기존값과 신규값 모두 확인 가능
        System.out.println("obj1 = " + obj1.getValue());
        System.out.println("obj2 = " + obj2.getValue());


        /*
            가변 객체의 경우는 기존 값이 덮어써지기 때문에 연산 전의 값을 잃어버린다.
         */
        MutableObj obj = new MutableObj(10);
        obj.add(20);

        // 계산 이후의 기존 값은 사라짐
        System.out.println("obj = " + obj.getValue());
    }

}
