package basic.etc;

public class VariableArgument {

    public static int sum(int... n) {
        int sum = 0;
        for (int num : n) {
            sum += num;
        }

        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        sum(1); // 1
        sum(1, 2, 3); // 6
        sum(1, 2, 3, 4, 5); // 15
    }
}
