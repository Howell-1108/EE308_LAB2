//import java.io.BufferedReader;
import java.io.*;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class StringCompare {
    public static void main(String[] args) throws IOException {
//        String a = "float";
//        String b = "double";
//        String c = "float";
//        System.out.println(a.equals(b));
//        System.out.println(a.equals(c));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter the path of file.");
        str = br.readLine();
        System.out.println(str);
        String filePath = "C:\\Users\\sazic\\Desktop\\Y3_1\\EE308 SE\\lab\\LAB2\\test_file.c";
        FileReader fileReader = new FileReader(filePath);

        char[] chars = new char[5000];
        fileReader.read(chars);
        for(char ch : chars){
            System.out.print(ch);
        }

    }
}
//C:\Users\sazic\Desktop\Y3_1\EE308 SE\lab\LAB2\test_file.c