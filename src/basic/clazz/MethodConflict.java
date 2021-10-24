package basic.clazz;

import java.io.*;

interface Student {
    default String getId() {
        return "1000";
    }
}

interface Employee {
    default String getId() {
        return "9000";
    }
}

class Person implements Student, Employee {
    @Override
    public String getId() {
        return Employee.super.getId(); // 동일한 이름의 메서드가 존재할 경우, 직접 명시를 해줘야한다.
    }
}

public class MethodConflict {

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        System.out.println(person.getId()); // 9000
    }

}
