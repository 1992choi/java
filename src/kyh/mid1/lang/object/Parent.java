package kyh.mid1.lang.object;

/*
    부모가 없으면 묵시적으로 Object 클래스를 상속받는다.
    - 'public class Parent extends Object' 대신에 'public class Parent'만 기술해도 된다.
    - 컴파일러가 알아서 Object를 상속받게끔 동작한다.
*/
public class Parent {

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }

}
