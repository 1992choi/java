package algorithm.codingtest.cospro;

/*
    - 문제 1
    어느 누군가가 타임머신을 타고 과거로 가서 숫자 0이 없는 수 체계를 전파했습니다.
    역사가 바뀌어 이제 사람들의 의식 속엔 0이란 숫자가 사라졌습니다.
    따라서, 현재의 수 체계는 1, 2, 3, ..., 8, 9, 11, 12, ...와 같이 0이 없게 바뀌었습니다.
    0을 포함하지 않은 자연수 num이 매개변수로 주어질 때, 이 수에 1을 더한 수를 return 하도록 solution 메소드를 완성해주세요.
 */
public class Solution_1_1 {

    public long solution(long num) {
        num++;
        long digit = 1;
        while (num / digit % 10 == 0) {
            num += digit;
            digit *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution_1_1 sol = new Solution_1_1();
        long num = 9949999;
        System.out.println(sol.solution(num)); // 9951111
    }

}
