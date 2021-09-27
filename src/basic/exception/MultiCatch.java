package basic.exception;

public class MultiCatch {

    public static void main(String[] args) {
        try {
            // int a = 1 / 0;
            // int b = Integer.parseInt("b");
            String c = args[0];
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException 발생");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException 발생");
        }

        /*
            자바 7부터는 하나의 catch에서 '|' 기호로 통합하여 작성할 수 있다.
        */
        try {
            // int a = 1 / 0;
            // int b = Integer.parseInt("b");
            String c = args[0];
        } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
            /*
                int a = 1 / 0                   ->  java.lang.ArithmeticException: / by zero
                int b = Integer.parseInt("b");  ->  java.lang.NumberFormatException: For input string: "b"
                String c = args[0];             ->  java.lang.ArrayIndexOutOfBoundsException: 0
            */
        }
    }

}
