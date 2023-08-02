package basic.clazz;

class OverLoadingEx {

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public double sum(double num1, double num2) {
        return num1 + num2;
    }

//    접근제어자는 오버로딩의 조건이 아니다.
//    private int sum(int num1, int num2) {
//        return num1 + num2;
//    }
//
//    리턴타입은 오버로딩의 조건이 아니다.
//    public double sum(int num1, int num2) {
//        return (double)(num1 + num2);
//    }

}

class ParentClass {
    void sayName(String name) {
        System.out.println("[부모클래스] name=" + name);
    }
}

class ChildClass extends ParentClass {
    @Override
    void sayName(String name) {
        System.out.println("[자식클래스] name=" + name);
    }
}

public class OverloadingAndOverriding {

    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        parent.sayName("choi"); // [부모클래스] name=choi

        ChildClass child = new ChildClass();
        child.sayName("choi"); // [자식클래스] name=choi
    }

}
