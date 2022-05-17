package basic.clazz;

public class Variables {

    int iv; // 인스턴스 변수 : 인스턴스가 생성되었을 때 생성
    static int cv; // 클래스 변수(=static 변수, 공유변수) : 클래스가 메모리에 로드될 때 생성
    
    void method() {
        int lv = 0; // 지역변수 : 변수 선언문이 수행되었을 때 생성
    }

}
