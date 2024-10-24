package basic.exception;

public class ExceptionEx {

    public static void main(String[] args) {
        /*
            CustomException_1 이 발생 시 핸들링
            - catch (CustomException_1 e)를 통해 CustomException_1 핸들링 성공
             - 실행결과 : catch CustomException
         */
        try {
            run(1);
            System.out.println("run Success");
        } catch (CustomException_1 e) {
            System.out.println("catch CustomException");
        }



        /*
            CustomException_2 이 발생 시 핸들링
            - catch (Exception e)를 통해 CustomException_2 핸들링 성공
              - 실행결과 : catch CustomException_2
            - Exception은 CustomException_2의 부모 클래스이기 때문에 CustomException_2가 발생해도 Exception로 핸들링 가능하다.
         */
        try {
            run(2);
            System.out.println("run Success");
        } catch (Exception e) {
            System.out.println("catch CustomException_2");
        }



        /*
            CustomException_1 이 발생 시 핸들링
            - catch (CustomException_2 e)를 통해 CustomException_1 핸들링 실패
            - CustomException_2는 CustomException_1의 부모 클래스가 아니기 때문에 Exception 발생 시 핸들링하지 못한다.
            - 단 핸들링하지 못해도 finally는 수행한다.
         */
        try {
            run(1);
            System.out.println("run Success");
        } catch (CustomException_2 e) {
            System.out.println("catch CustomException_2");
        } finally {
            System.out.println("finally"); // 실행됨.
        }
    }

    public static void run(int type) {
        if (type == 1) {
            throw new CustomException_1();
        } else if (type == 2) {
            throw new CustomException_2();
        }
    }

}

class CustomException_1 extends RuntimeException {}
class CustomException_2 extends RuntimeException {}
