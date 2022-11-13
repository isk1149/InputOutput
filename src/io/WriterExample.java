package io;

import java.io.FileWriter;
import java.io.Writer;

/*
    Writer는 문자 기반 출력 스트림의 최상위 클래스이면서 추상 클래스이다.
    void | write(int c) | 매개값으로 주어진 한 문자를 보냄
                          매개 변수로 주어지는 int(4byte)의 끝(오른쪽) 2byte(1개의 문자)만 출력 스트림으로 보냄
    void | write(char[] cbuf) | 매개값으로 주어진 배열의 모든 문자를 보냄
    void | write(char[] cbuf, int off, int len) | 매개값으로 주어진 배열에서 cbuf[off]부터 len개까지의 문자를 보냄
    void | write(String str) | 매개값으로 주어진 문자열을 보냄
    void | write(String str, int off, int len) | 매개값으로 주어진 문자열에서 off 순번부터 len개까지의 문자를 보냄
    void | flush() | 버퍼에 잔류하는 모든 문자를 출력
    void | close() | 출력 스트림을 닫음
 */
public class WriterExample {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("C:/java_io_test/test7.txt");

        char a = 'A', b = 'B', c = 'C';

        writer.write(a);
        writer.write(b);
        writer.write(c);

        writer.flush();
        writer.close();

        /**********************************************************************************/

        Writer writer2 = new FileWriter("C:/java_io_test/test8.txt");

        char[] array2 = {'A', 'B', 'C'};

        writer2.write(array2);

        writer2.flush();
        writer2.close();

        /**********************************************************************************/

        Writer writer3 = new FileWriter("C:/java_io_test/test9.txt");

        char[] array3 = {'A', 'B', 'C', 'D', 'E'};

        writer3.write(array3, 1, 3);

        writer3.flush();
        writer3.close();

        /**********************************************************************************/

        Writer writer4 = new FileWriter("C:/java_io_test/test10.txt");

        String str = "ABCDEFG";

        writer4.write(str);

        writer4.flush();
        writer4.close();

        /**********************************************************************************/

        Writer writer5 = new FileWriter("C:/java_io_test/test11.txt");

        String str2 = "ABCDEFG";

        writer5.write(str2, 2, 3);

        writer5.flush();
        writer5.close();

    }
    
}
