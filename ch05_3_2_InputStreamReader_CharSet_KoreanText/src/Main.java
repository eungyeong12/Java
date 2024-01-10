import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;
        String f_name = "kor text.txt";
        try {
            fin = new FileInputStream(f_name);
            in = new InputStreamReader(fin, "UTF-8");
            int ch;
            System.out.printf("Encoding char set=%s\n", in.getEncoding());
            while((ch = in.read()) != -1) {
                System.out.printf("%c", (char)ch);
            }
            in.close();
            fin.close();
        } catch (IOException e) {
            System.out.printf("IOException in Korean text reading !!\n");
        }
    }
}