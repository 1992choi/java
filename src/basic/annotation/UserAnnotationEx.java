package basic.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능
@interface DateAnnotation {
    String yymmdd();
    String hhmmss();
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능
@interface CustomAnnotation {
    int number1() default 1; // default 값 설정 가능
    int number2();
    String str();
    String[] arr() default {"Java", "Spring"};
    DateAnnotation date(); // 자신이 아닌 다른 어노테이션 포함 가능
}

@CustomAnnotation(number2 = 7, str = "choi", date = @DateAnnotation(yymmdd = "20220701", hhmmss = "215100"))
public class UserAnnotationEx {

    public static void main(String[] args) {
        // UserAnnotationEx 클래스에 적용된 어노테이션 가져오기
        Class<UserAnnotationEx> clazz = UserAnnotationEx.class;

        // 어노테이션 가져오기(클래스 객체에는 해당 클래스에 대한 정보뿐만 아니라 어노테이션의 정보도 가지고 있다.)
        CustomAnnotation customAnnotation = clazz.getAnnotation(CustomAnnotation.class);

        System.out.println(customAnnotation.number1()); // 1
        System.out.println(customAnnotation.number2()); // 7
        System.out.println(customAnnotation.str()); // choi
        System.out.println(Arrays.toString(customAnnotation.arr())); // [Java, Spring]
        System.out.println(customAnnotation.date().yymmdd()); // 20220701
        System.out.println(customAnnotation.date().hhmmss()); // 215100
    }

}
