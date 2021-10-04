package basic.io;

import java.io.*;

public class FileWriterEx {

    public static void main(String[] args) throws IOException {
        /*
            Reader(FileReader, BufferedReader, InputStreamReader)와
            Writer(FileWriter, BufferedWriter, OutputStreamWriter)는
            기존 예제(xxxStreamEx)와 다르게 byte단위의 입출력이 아닌 char단위의 입출력으로 문자열 입출력을 위해 특화된 기법이다.
         */
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "xxxWriter.txt");
        Writer writer = new FileWriter(file);
        writer.write("안녕하세요\n");
        writer.write("hi");
        writer.write('\n');
        writer.write("20211004");
        writer.flush();
        writer.close();
        /*
            실행결과
            : 안녕하세요
              hi
              20211004
         */

        Writer writer2 = new FileWriter(file, true); // 이어쓰기(false일 경우, 덮어쓰기)
        writer2.write('\n');
        writer2.write("이어쓰기");
        writer2.flush();
        writer2.close();
        /*
            실행결과
            : 안녕하세요
              hi
              20211004
              이어쓰기  <- 이어쓰기된 문장
         */
    }

}
