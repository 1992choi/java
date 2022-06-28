package basic.enumeration;

enum Direction {EAST, SOUTH, WEST, NORTH} // 순차적 값을 가진다.(EAST=0, SOUTH=1, WEST=2, NORTH=3)

public class EnumBasicEx {

    public static void main(String[] args) {
        // 값을 가져오는 방법
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1); // d1 = EAST
        System.out.println("d2 = " + d2); // d2 = WEST
        System.out.println("d3 = " + d3); // d3 = EAST

        // 열거형 상수의 비교는 ==와 compareTo()가 가능하다.
        System.out.println("d1==d2 ? " + (d1 == d2)); // d1==d2 ? false
        System.out.println("d1==d3 ? " + (d1 == d3)); // d1==d3 ? true
        System.out.println("d1.equals(d3) ? " + d1.equals(d3)); // d1.equals(d3) ? true
//		System.out.println("d2 > d3 ? "+ (d1 > d3)); // 오류발생. 비교 연산자를 사용할 수 없다.
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3))); // d1.compareTo(d3) ? 0
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2))); // d1.compareTo(d2) ? -2

        switch (d1) {
            case EAST: // 주의! Direction.EAST의 형태가 아님
                System.out.println("The direction is EAST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case NORTH:
                System.out.println("The direction is NORTH.");
                break;
            default:
                System.out.println("Invalid direction.");
        }
        // switch result : The direction is EAST.

        Direction[] dArr = Direction.values();
        for (Direction d : dArr) { // for(Direction d : Direction.values())
            System.out.println(d.name() + "=" + d.ordinal());
        }
        /*
            EAST=0
            SOUTH=1
            WEST=2
            NORTH=3
         */
    }

}
