package basic.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    int no;
    String name;

    Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + no + ":" + name + "]";
    }
}

public class CollectEx {

    public static void main(String[] args) {
        /*
            - Stream.collect()
              : 데이터 처리 후 원하는 형태로 변환해준다.
        */

        // 1. List로 변환
        Stream<Student> stream1 = Stream.of(
                new Student(1, "choi"),
                new Student(2, "kim"),
                new Student(3, "lee"),
                new Student(4, "park")
        );

        List<Student> list = stream1.collect(Collectors.toList());
        System.out.println(list); // [[1:choi], [2:kim], [3:lee], [4:park]]



        // 2. ArrayList로 변환
        Stream<Student> stream2 = Stream.of(
                new Student(1, "choi"),
                new Student(2, "kim"),
                new Student(3, "lee"),
                new Student(4, "park")
        );

        ArrayList<Student> arrayList = stream2.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList); // [[1:choi], [2:kim], [3:lee], [4:park]]



        // 3. Map으로 변환
        Stream<Student> stream3 = Stream.of(
                new Student(1, "choi"),
                new Student(2, "kim"),
                new Student(3, "lee"),
                new Student(4, "park")
        );

        Map<Integer, Student> map = stream3.collect(Collectors.toMap(s -> s.no, s -> s)); // 학생 no를 key로 만든다.
        System.out.println(map); // {1=[1:choi], 2=[2:kim], 3=[3:lee], 4=[4:park]}
    }

}
