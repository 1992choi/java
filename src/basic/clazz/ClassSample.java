package basic.clazz;

class outerClass1 { // 외부 클래스 1
    // ...
}

class outerClass2 { // 외부 클래스 2
    // ...
}

public class ClassSample {

    // 필드
    int value;

    // 메서드
    int sum(int param1, int param2) {
        return param1 + param2;
    }

    // 생성자
    ClassSample() {
        // ...
    }

    // 이너 클래스
    class innerClass {
        // ...
    }

}
