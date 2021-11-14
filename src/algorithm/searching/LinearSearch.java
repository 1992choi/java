package algorithm.searching;

public class LinearSearch {

    public static void main(String[] args) {
        int idx = -1;
        int[] num = {5, 9, 1, 6, 3, 2, 8, 7};
        int findNum = 4;

        for (int i = 0; i < num.length; i++) {
            if (num[i] == findNum) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(findNum + "은(는) 존재하지 않습니다.");
        } else {
            System.out.println(findNum + "은(는) " + idx + "번째에 존재합니다.");
        }
    }

}
