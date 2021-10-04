package basic.io;

import java.io.*;

public class PrinterWriterEx {

    public static void main(String[] args) throws IOException {
        /*
            Reader(FileReader, BufferedReader, InputStreamReader)와
            Writer(FileWriter, BufferedWriter, OutputStreamWriter)는
            기존 예제(xxxStreamEx)와 다르게 byte단위의 입출력이 아닌 char단위의 입출력으로 문자열 입출력을 위해 특화된 기법이다.
         */
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "xxxWriter.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println("가나다");
        pw.println("abc");
        pw.println(123);
        // pw.flush(); : 자동 flush()기능을 제공
        pw.close();
        /*
            실행결과
            : 가나다
              abc
              123
         */
    }

}
