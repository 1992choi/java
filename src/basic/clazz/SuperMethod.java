package basic.clazz;

class Parent {
    Parent() {
        System.out.println("Parent 생성");
    }

    void init() {
        System.out.println("Parent의 init()");
    }
}

class Child extends Parent {
    Child() {
        super(); // 생략했을 때 컴파일러가 자동 추가
        System.out.println("Child 생성");
    }

    void init() {
        /*
            - 부모 메서드를 호출하는 경우
              : 부모의 init메서드에 초기화 코드가 들어있다고 가정했을 때,
                자식 클래스에서도 부모의 init메서드와 동일한 기능을 하며 +a의 기능을 추가하고자 할 때,
                super 키워드를 사용하지 않으면 중복 코드를 작성해야한다.
                반면 super 키워드를 사용할 경우 중복 코드를 제거할 수 있다.
         */
        super.init();
        System.out.println("Child의 init()");
    }
}

public class SuperMethod {

    public static void main(String[] args) {
        Child c = new Child();
        /*
            result
            - 출력 : Parent 생성
            - 출력 : Child 생성
        */
        
        c.init();
        /*
            result
            - 출력 : Parent의 init() -> super.init();를 사용했기 때문
            - 출력 : Child의 init()
        */
    }
    
}
