package algorithm.searching;

public class BinarySearch {

    public static int binarySearch(int[] num, int findNum) {
        int leftCursor = 0;
        int rightCursor = num.length - 1;

        while (leftCursor <= rightCursor) {
            int cursor = (leftCursor + rightCursor) / 2;
            if (num[cursor] == findNum) {
                return cursor;
            } else {
                if (num[cursor] > findNum) {
                    rightCursor = cursor - 1;
                } else {
                    leftCursor = cursor + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 4, 6, 7, 12, 18, 27}; // 이진 검색의 검색할 데이터들이 이미 정렬되어 있어야 한다.
        int findNum = 7;

        int returnVal = binarySearch(num, findNum);
        System.out.println(returnVal == -1 ? "값이 존재하지 않습니다." : returnVal + "번째 존재합니다.");
    }

}
