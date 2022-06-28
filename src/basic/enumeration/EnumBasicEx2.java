package basic.enumeration;

/*
    enum Direction {EAST, SOUTH, WEST, NORTH} // 순차적 값을 가진다.(EAST=0, SOUTH=1, WEST=2, NORTH=3)

    : 위의 주석(EnumBasicEx.java 코드)처럼 순차적 값을 가진다고 하였지만,
      아래와 같이 값을 지정할 수 있다.
*/
enum Direction2 {
    EAST(10, "→"), SOUTH(20, "↓"), WEST(30, "←"), NORTH(40, "↑");

    private final int value;
    private final String symbol;

    Direction2(int value, String symbol) { /* private 생략 */
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class EnumBasicEx2 {

    public static void main(String[] args) {
        // 값을 가져오는 방법
        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.values()[2];

        System.out.println(d1.name() + ":" + d1.getValue() + ":" + d1.getSymbol()); // EAST:10:→
        System.out.println(d2.name() + ":" + d2.getValue() + ":" + d2.getSymbol()); // WEST:30:←
    }

}
