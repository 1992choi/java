package basic.record;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecordVsClass {

    // class
    static class PersonClass {
        private String name;
        private int age;

        public PersonClass(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // record
    record PersonRecord(String name, int age) {
        // 별도 코드 없이도 equals, hashCode, toString이 자동 생성됨
    }

    public static void main(String[] args) {
        // class
        PersonClass class1 = new PersonClass("Alice", 30);
        PersonClass class2 = new PersonClass("Alice", 30);
        System.out.println("class1.equals(class2): " + class1.equals(class2)); // false

        Set<PersonClass> classSet = new HashSet<>(Arrays.asList(class1, class2));
        System.out.println("classSet.size(): " + classSet.size()); // 2

        System.out.println("class1.toString(): " + class1.toString()); // basic.recode.RecordVsClass$PersonClass@4f023edb
        // class1.getName(); // 호출불가

        // record
        PersonRecord record1 = new PersonRecord("Alice", 30);
        PersonRecord record2 = new PersonRecord("Alice", 30);
        System.out.println("record1.equals(record2): " + record1.equals(record2)); // true

        Set<PersonRecord> recordSet = new HashSet<>(Arrays.asList(record1, record2));
        System.out.println("recordSet.size(): " + recordSet.size()); // 1

        System.out.println("record1.toString(): " + record1.toString()); // PersonRecord[name=Alice, age=30]

        System.out.println(record1.name()); // 클래스와 다르게 필드에 대한 getter를 기본으로 제공해준다.
    }

}
