package util.string;

public class SequenceEx {

    public static void main(String[] args) {
        String currentSeq = "009";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "0A7";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "0AB";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "0A9";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "0Z9";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "0ZZ";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "877";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "999";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "99Z";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "9ZZ";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "9ZZ";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "ZZZ";
        System.out.println(increaseSeq(currentSeq));

        currentSeq = "871";
        while (true) {
            currentSeq = increaseSeq(currentSeq);
            System.out.println("currentSeq = " + currentSeq);
            if ("Error".equals(currentSeq)) {
                break;
            }
        }
    }

    public static String increaseSeq(String seq) {
        boolean overflowOnes = false; // 1의 자리에서 받아올림이 발생하였는지 여부
        boolean overflowTens = false; // 10의 자리에서 받아올림이 발생하였는지 여부
        StringBuilder sb = new StringBuilder();
        char[] seqChar = seq.toCharArray();

        // 1의 자리 계산
        if (seqChar[2] == '9') {
            seqChar[2] = 'A';
        } else if (seqChar[2] == 'Z') {
            seqChar[2] = '0';
            overflowOnes = true;
        } else {
            seqChar[2] = (char) ((int) seqChar[2] + 1);
        }

        // 10의 자리 계산
        if (overflowOnes) {
            if (seqChar[1] == '9') {
                seqChar[1] = 'A';
            } else if (seqChar[1] == 'Z') {
                seqChar[1] = '0';
                overflowTens = true;
            } else {
                seqChar[1] = (char) ((int) seqChar[1] + 1);
            }
        }

        // 100의 자리 계산
        if (overflowTens) {
            if (seqChar[0] == '9') {
                seqChar[0] = 'A';
            } else if (seqChar[0] == 'Z') {
                // 오류 케이스 (000 ~ ZZZ만 채번 중인데 100의 자리가 Z가 넘으면 중복이 발생하므로 오류 케이스에 해당)
                return "Error";
            } else {
                seqChar[0] = (char) ((int) seqChar[0] + 1);
            }
        }

        return sb.append(seqChar[0]).append(seqChar[1]).append(seqChar[2]).toString();
    }

}
