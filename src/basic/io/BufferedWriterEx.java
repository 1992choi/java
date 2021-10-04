package basic.io;

import java.io.*;

public class BufferedWriterEx {

    public static void main(String[] args) throws IOException {
        /*
            Reader(FileReader, BufferedReader, InputStreamReader)와
            Writer(FileWriter, BufferedWriter, OutputStreamWriter)는
            기존 예제(xxxStreamEx)와 다르게 byte단위의 입출력이 아닌 char단위의 입출력으로 문자열 입출력을 위해 특화된 기법이다.
         */
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "xxxWriter.txt");
        Writer writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("가나다\n");
        bw.write("123");
        bw.write('\n');
        bw.write("abc");
        bw.flush();
        bw.close();
        /* 실행결과
           : 가나다
             123
             abc
         */
    }

}
