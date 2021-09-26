package basic.interfaces;

interface A {
    void Amethod();
    void Bmethod();

    /*
        자바 8에서 인터페이스 내에 완성된 메서드인 디폴트 메서드가 포함할 수 있게 되었다.
        아래의 Aclass와 Bclass가 A 인터페이스의 Amethod(), Bmethod()를 구현한 상황에서
        추가 기능을 가지는 Cclass가 만들어진다고 가정할 때,
        추가 기능을 위하여 인터페이스 A에 Cmethod()가 추가된다고하면
        기존에 작성된 Aclass와 Bclass에서는 오류가 발생할 것이다.
        이 때 Cmethod를 디폴트 메서드를 사용한다면 이러한 이슈를 해결할 수 있다.
     */
    default void Cmethod() {

    }
}

class Aclass implements A {
    @Override
    public void Amethod() {}

    @Override
    public void Bmethod() {}

    // Cmethod가 추가되기 전에 작성되었던 Aclass에서는 Cmethod()를 구현하지 않아도 오류가 발생하지 않는다.
}

class Bclass implements A {
    @Override
    public void Amethod() {}

    @Override
    public void Bmethod() {}

    // Cmethod가 추가되기 전에 작성되었던 Bclass에서는 Cmethod()를 구현하지 않아도 오류가 발생하지 않는다.
}

class Cclass implements A {
    @Override
    public void Amethod() {}

    @Override
    public void Bmethod() {}

    @Override
    public void Cmethod() {
        A.super.Cmethod();
    }
}

public class DefaultMethod {

    public static void main(String[] args) {

    }

}
