package basic.control_statements;

public class EnhancedForLoop {

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1, 9};

        // 기존 for문
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i : " + arr[i]);
        }

        // 향상된 for문
        for (int i : arr) {
            System.out.println("i : " + i);
        }
    }

}
