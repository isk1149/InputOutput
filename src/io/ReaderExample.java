package io;

import java.io.FileReader;
import java.io.Reader;

/*
    Reader는 문자 기반 입력 스트림의 최상위 클래스이면서 추상 클래스이다.
    int | read() | 1개의 문자를 읽고 리턴
                   입력 스트림으로부터 1개의 문자(2byte)를 읽고 int(4byte) 타입으로 리턴
                   따라서 리턴된 4byte 중 끝(오른쪽)에 있는 2byte에 문자 데이터가 들어있다
                   (char)read()를 하면 읽은 문자를 얻을 수 있다
                   더 이상 입력 스트림으로부터 문자를 읽을 수 없다면 -1 리턴
                   이것을 이용해 읽을 수 있는 마지막 문자까지 반복하면서 한 문자씩 읽을 수 있음
    int | read(char[] cbuf) | 읽은 문자들을 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴
                              실제 읽은 문자가 배열의 길이보다 적을 경우 읽은 수만큼만 리턴
                              더 이상 입력 스트림으로부터 문자를 읽을 수 없다면 -1 리턴
                              이것을 이용해 읽을 수 있는 마지막 문자까지 반복하면서 한 문자씩 읽을 수 있음
    int | read(char[] cbuf, int off, int len) | len개의 문자를 읽고 매개값으로 주어진 문자 배열에서
                                                cbuf[off]부터 len개까지 저장한다. 그리고 읽은 문자 수를 리턴
                                                실제 읽은 문자수가 len개보다 적으면 읽은 수만큼만 리턴
                                                off를 0으로, len을 배열의 길이로 주면 read(char[] cbuf)와 동일
    void | close() | 입력 스트림을 닫음
 */
public class ReaderExample {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("C:/java_io_test/test7.txt");

        while(true) {
            int data = reader.read();
            if(data == -1) break;
            System.out.println((char)data);
        }

        reader.close();
        System.out.println();
        /**********************************************************************************/

        Reader reader2 = new FileReader("C:/java_io_test/test8.txt");

        char[] buffer = new char[100];

        while (true) {
            int readCharNum = reader2.read(buffer);
            if (readCharNum == -1) break;
            for (int i = 0; i < readCharNum; i++) {
                System.out.print(buffer[i]);
            }
            System.out.println();
        }

        reader2.close();
        System.out.println();
        /**********************************************************************************/

        Reader reader3 = new FileReader("C:/java_io_test/test9.txt");

        char[] buffer2 = new char[5];

        int readCharNum = reader3.read(buffer2, 2, 3);
        if (readCharNum != -1) {
            for (int i = 0; i < buffer2.length; i++) {
                System.out.println(buffer2[i]);
            }
        }

        reader3.close();

    }
}
