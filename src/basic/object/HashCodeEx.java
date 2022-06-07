package basic.object;

import java.util.Objects;

class Card1 {
    String kind;
    int number;

    Card1(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
}

class Card2 {
    String kind;
    int number;

    Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, number); // Objects.hash()는 매개변수가 가변인자라서 값의 개수가 정해져있지 않다.
    }
}

public class HashCodeEx {

    public static void main(String[] args) {
        // hashCode 재정의 X (hashCode값이 다르다.)
        Card1 a = new Card1("SPADE", 7);
        Card1 b = new Card1("SPADE", 7);
        System.out.println(a.hashCode()); // 1735600054
        System.out.println(b.hashCode()); // 21685669

        // hashCode 재정의 O (hashCode값이 같다.)
        // 통상적으로 equals()를 재정의하면 hashCode()도 재정의한다.
        Card2 c = new Card2("SPADE", 7);
        Card2 d = new Card2("SPADE", 7);
        System.out.println(c.hashCode()); // -1842861213
        System.out.println(d.hashCode()); // -1842861213
    }

}
