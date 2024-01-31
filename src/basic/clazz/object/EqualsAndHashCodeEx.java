package basic.clazz.object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCodeEx {

    public static void main(String[] args) {
        // equals(), hashCode() 재정의 X
        UserCase1 userCaseA = new UserCase1(1, "choi");
        UserCase1 userCaseB = new UserCase1(1, "choi");
        System.out.println(userCaseA.equals(userCaseB)); // false
        Set<UserCase1> set1 = new HashSet<>();
        set1.add(userCaseA);
        set1.add(userCaseB);
        System.out.println(set1.size()); // 2

        // equals()만 재정의
        UserCase2 userCaseC = new UserCase2(1, "choi");
        UserCase2 userCaseD = new UserCase2(1, "choi");
        System.out.println(userCaseC.equals(userCaseD)); // true
        Set<UserCase2> set2 = new HashSet<>();
        set2.add(userCaseC);
        set2.add(userCaseD);
        System.out.println(set2.size()); // 2 -> hashCode()를 를 재정의하지 않으면 Collection에 담길 때 동등객체로 인식하지 않는다.

        // equals(), hashCode 재정의
        UserCase3 userCaseE = new UserCase3(1, "choi");
        UserCase3 userCaseF = new UserCase3(1, "choi");
        System.out.println(userCaseE.equals(userCaseF)); // true
        Set<UserCase3> set3 = new HashSet<>();
        set3.add(userCaseE);
        set3.add(userCaseF);
        System.out.println(set3.size()); // 1
    }

}

/**
 * equals()와 hashCode() 재정의 안함
 */
class UserCase1 {
    int id;
    String name;

    public UserCase1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * equals()만 재정의
 */
class UserCase2 {
    int id;
    String name;

    public UserCase2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCase2 userCase2 = (UserCase2) o;
        return id == userCase2.id && Objects.equals(name, userCase2.name);
    }
}

/**
 * equals()와 hashCode() 재정의
 */
class UserCase3 {
    int id;
    String name;

    public UserCase3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCase3 userCase3 = (UserCase3) o;
        return id == userCase3.id && Objects.equals(name, userCase3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
