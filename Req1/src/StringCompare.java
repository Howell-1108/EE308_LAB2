//import java.io.BufferedReader;
import java.io.*;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class StringCompare {
    int keywordNum = 0;
    public static void check (String [] objectString){
        int stringLen = objectString.length;
        for(int i = 0 ; i <= stringLen ; i++){

        }
    }

    public static void main(String[] args) throws IOException {


        String filePath = "C:\\Users\\sazic\\Desktop\\Y3_1\\EE308 SE\\lab\\LAB2\\test_file.c";
        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        while(line != null){
            System.out.println(line);

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        fileReader.close();




    }
}
//C:\Users\sazic\Desktop\Y3_1\EE308 SE\lab\LAB2\test_file.c
// 12112233

//        String a = "float";
//        String b = "double";
//        String c = "float";
//        System.out.println(a.equals(b));
//        System.out.println(a.equals(c));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        System.out.println("Enter the path of file.");
//        str = br.readLine();
//        System.out.println(str);



//        char[] chars = new char[5000];
//        fileReader.read(chars);
//        for(char ch : chars){
//            System.out.print(ch);
//        }
//        StringBuilder currentWord = new StringBuilder(20);
//
//        int fileLength = chars.length;
//        System.out.println(fileLength);

//        for(char ch : chars){
//            if(ch >= 'a' && ch <= 'z'){
//                assert currentWord != null;
//                currentWord.append();
//            }else{
//                if(currentWord != null){
//                    System.out.println(currentWord);
//                }
//                currentWord = null;
//            }
//        }

/* ///*/
//   /*

//
//    if(i<0)
//		if (i>2) printf(" ");
//        else if (i==2) printf(" ");
//        else if (i>1) printf(" ");
//        else printf(" ");
//    else
//    	printf(" ");