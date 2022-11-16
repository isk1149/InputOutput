package io;

import java.io.*;

/*
    문자 변환 보조 스트림
    소스 스트림이 바이트 기반 스트림(InputStream, OutputStream, FileInputStream, FileOutputStream)이면서
    입출력 데이터가 문자라면 Reader와 Writer로 변환해서 사용하는 것을 고려할 수 있다.
    문자 입출력은 Reader와 Writer가 편리하기 때문이다.

    OutputStreamWriter는 바이트 기반 출력 스트림에 연결되어 문자 출력 스트림인 Writer로 변환하는 보조 스트림이다.
    Writer writer = new OutputStreamWriter(바이트 기반 출력 스트림);
    ex)
    FileOutputStream fos = new FileOutputStream("C:/Temp/text1.txt");
    Writer writer = new OutputStreamWriter(fos);

    InputStreamReader는 바이트 기반 입력 스트림에 연결되어 문자 입력 스트림인 Reader로 변환하는 보조 스트림이다.
    Reader reader = new InputStreamReader(바이트 기반 입력 스트림);
    ex)
    FileInputStream fis = new FileInputStream("C:/Temp/text1.txt");
    Reader reader = new InputStreamReader(fis);
 */
public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws Exception {
        FileOutputStream fos = new FileOutputStream("C:/java_io_test/test1.txt");
        Writer writer = new OutputStreamWriter(fos);
        writer.write(str);
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
        FileInputStream fis = new FileInputStream("C:/java_io_test/test1.txt");
        Reader reader = new InputStreamReader(fis);
        char[] buffer = new char[100];
        int readCharNum = reader.read(buffer);
        String data = new String(buffer, 0, readCharNum);
        reader.close();
        return data;
    }
}
