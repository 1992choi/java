package algorithm.codingtest.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42577
public class 전화번호_목록 {

    public static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                String a = phone_book[i];
                String b = phone_book[j];
                if (a.startsWith(b) || b.startsWith(a)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
