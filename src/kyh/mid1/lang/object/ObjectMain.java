package kyh.mid1.lang.object;

public class ObjectMain {

    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod(); // Child.childMethod
        child.parentMethod(); // Parent.parentMethod

        /*
            Object 클래스의 메서드이다.
            Child는 Object를 직접 상속받지는 않았지만,
            부모 클래스인 Parent를 상속받았기 때문에 Parent가 상속받았던 Object의 메서드를 사용할 수 있는 것이다.
         */
        child.toString();


        /*
            Object 클래스가 최상위 부모 클래스인 이유
            - 공통 기능을 제공하기 위함
              - 객체의 정보를 제공하는 toString()
              - 같음을 비교하는 equals()
              - 객체의 클래스 정보를 제공하는 getClass()
              - 기타 여러가지 기능
            - 다형성의 기본 구현
              - 부모는 자식을 담을 수 있다.
              - Object는 모든 클래스의 부모 클래스이기 때문에 모든 객체를 참조할 수 있다.
              - 때문에 Object는 다형성을 지원하는 기본적인 메커니즘을 제공한다.
         */
    }

}
