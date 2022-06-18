package basic.clazz.object;

class Person1 {
    long id;

    Person1(long id) {
        this.id = id;
    }
}

class Person2 {
    long id;

    Person2(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person2)) {
           return false;
        }

        Person2 person = (Person2)obj;
        return this.id == person.id;
    }
}

public class EqualsEx {

    public static void main(String[] args) {
        // equals 재정의 X (Object클래스의 equals메서드는 주소값을 비교하게 되어있다.)
        Person1 a = new Person1(10);
        Person1 b = new Person1(10);
        System.out.println(a.equals(b)); // false

        // equals 재정의 O (equals메서드를 재정의하여 주소값이 아닌 값을 비교하게 구현하였다.)
        Person2 c = new Person2(10);
        Person2 d = new Person2(10);
        System.out.println(c.equals(d)); // true
    }

}
