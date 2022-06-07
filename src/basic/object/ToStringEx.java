package basic.object;

class Car1 {
    String color;
    int number;

    Car1(String color, int number) {
        this.color = color;
        this.number = number;
    }
}

class Car2 {
    String color;
    int number;

    Car2(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "색상 : " + color + ", 차량번호 : " + number;
    }
}

public class ToStringEx {

    public static void main(String[] args) {
        // toString 재정의 X (재정의를 하지 않으면, '클래스명@16진수의 해시 코드' 형태로 값을 반환한다.)
        Car1 a = new Car1("검정", 1234);
        System.out.println(a.toString()); // basic.object.Car1@677327b6

        // toString 재정의 O (사용자가 정의한 포맷으로 값을 반환한다.)
        Car2 b = new Car2("검정", 1234);
        System.out.println(b.toString()); // 색상 : 검정, 차량번호 : 1234
    }

}
