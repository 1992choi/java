package basic.enumeration;

public class StringVsEnum {

    public static void main(String[] args) {
        /*
            String의 경우, 타입 안전성 이슈가 있다.
            - 실수로 오타 등으로 인하여 없는 조건을 입력하면 원치않는 결과가 나올 수 있다.
            - Ex) VIP 등급이지만 대/소문자 구분을 제대로 하지 못해서 할인을 받지 못하는 경우 발생.
         */
        calcWithString("vip");



        /*
            Class를 사용하면 String에서의 이슈를 보완할 수 있다.
            - 단, 사용자가 직접 생성자를 만들면 동일한 이슈가 발생할 수 있으므로 public 생성자를 사용하지 못하도록  private으로 선언해야한다.
            - 또한 코드양이 많아진다는 단점이 있다.
         */
        // calcWithClass(new GradeClass());
        calcWithClass(GradeClass.VIP);



        /*
            ENUM을 사용하면 간편하게 이슈를 처리할 수 있다.
         */
        calcWithEnumGrade(GradeEnum.VIP);
    }

    static void calcWithString(String grade) {
        if ("NORMAL".equals(grade)) {
            System.out.println("NORMAL 등급은 10% 할인");
        } else if ("VIP".equals(grade)) {
            System.out.println("VIP 등급은 20% 할인");
        } else {
            System.out.println("비회원은 할인이 없습니다.");
        }
    }

    static void calcWithClass(GradeClass grade) {
        if (grade == GradeClass.NORMAL) {
            System.out.println("NORMAL 등급은 10% 할인");
        } else if (grade == GradeClass.VIP) {
            System.out.println("VIP 등급은 20% 할인");
        } else {
            System.out.println("비회원은 할인이 없습니다.");
        }
    }

    static void calcWithEnumGrade(GradeEnum grade) {
        if (grade == GradeEnum.NORMAL) {
            System.out.println("NORMAL 등급은 10% 할인");
        } else if (grade == GradeEnum.VIP) {
            System.out.println("VIP 등급은 20% 할인");
        } else {
            System.out.println("비회원은 할인이 없습니다.");
        }
    }

}

class GradeClass {

    public static final GradeClass NORMAL = new GradeClass();
    public static final GradeClass VIP = new GradeClass();

    private GradeClass() {}

}

enum GradeEnum {
    NORMAL, VIP;
}