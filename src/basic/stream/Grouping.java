package basic.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Member {
    String name; // 회원명
    int gender; // 성별 (1=남, 2=여)
    int level; // 회원등급 (1~3)
    int totalAmount; // 구매 총액

    public Member(String name, int gender, int level, int totalAmount) {
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.totalAmount = totalAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return name + ":" + gender + ":" + level + ":" + totalAmount;
    }
}

public class Grouping {

    public static void main(String[] args) {
        // 회원 구성
        Member[] members = {new Member("최영근", 1, 1, 90_000), new Member("홍길동", 1, 1, 85_000), new Member("둘리", 1, 1, 80_000), new Member("또치", 1, 2, 50_000), new Member("피카츄", 2, 2, 40_000), new Member("자바", 2, 2, 33_000), new Member("오라클", 1, 2, 35_000), new Member("마리아", 2, 3, 2_000), new Member("김아아", 1, 3, 3_200), new Member("이뜨아", 2, 3, 1_300), new Member("오라떼", 2, 3, 1_000)};

        System.out.println("1. 단순그룹화(성별)");
        Map<Integer, List<Member>> memberByGender = Stream.of(members)
                .collect(Collectors.groupingBy(Member::getGender));
        System.out.println(memberByGender);
        /*
            {
                1=[최영근:1:1:90000, 홍길동:1:1:85000, 둘리:1:1:80000, 또치:1:2:50000, 오라클:1:2:35000, 김아아:1:3:3200],
                2=[피카츄:2:2:40000, 자바:2:2:33000, 마리아:2:3:2000, 이뜨아:2:3:1300, 오라떼:2:3:1000]
            }
         */

        System.out.println("2. 단순그룹화(회원등급별)");
        Map<Integer, List<Member>> memberByLevel = Stream.of(members)
                .collect(Collectors.groupingBy(Member::getLevel));
        System.out.println(memberByLevel);
        /*
            {
                1=[최영근:1:1:90000, 홍길동:1:1:85000, 둘리:1:1:80000],
                2=[또치:1:2:50000, 피카츄:2:2:40000, 자바:2:2:33000, 오라클:1:2:35000],
                3=[마리아:2:3:2000, 김아아:1:3:3200, 이뜨아:2:3:1300, 오라떼:2:3:1000]
            }
         */

        System.out.println("3. 다중그룹화(성별, 회원등급별)");
        Map<Integer, Map<Integer, List<Member>>> memberByGenderAndLevel = Stream.of(members)
                .collect(Collectors.groupingBy(Member::getGender, Collectors.groupingBy(Member::getLevel)));
        System.out.println(memberByGenderAndLevel);
        /*
            {
                1={
                    1=[최영근:1:1:90000, 홍길동:1:1:85000, 둘리:1:1:80000],
                    2=[또치:1:2:50000, 오라클:1:2:35000],
                    3=[김아아:1:3:3200]
                   },
                2={
                    2=[피카츄:2:2:40000, 자바:2:2:33000],
                    3=[마리아:2:3:2000, 이뜨아:2:3:1300, 오라떼:2:3:1000]
                   }
             }
         */


        System.out.println("4. 다중그룹화 + 통계 (성별, 등급별 1등)");
        Map<Integer, Map<Integer, Member>> topMember = Stream.of(members)
                .collect(Collectors.groupingBy(
                        Member::getGender,
                            Collectors.groupingBy(Member::getLevel,
                                    Collectors.collectingAndThen(
                                            Collectors.maxBy(
                                                    Comparator.comparingInt(Member::getTotalAmount)
                                            ),
                                            Optional::get
                                    )
                            )
                        )
                );
        System.out.println(topMember);
        /*
            {
                1={
                    1=최영근:1:1:90000, 2=또치:1:2:50000, 3=김아아:1:3:3200
                   },
                2={
                    2=피카츄:2:2:40000, 3=마리아:2:3:2000
                   }
             }
         */
    }

}
