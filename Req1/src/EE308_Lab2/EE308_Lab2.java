package EE308_Lab2;

import java.io.*;
import java.util.HashSet;

public class EE308_Lab2 {
    private static int keywordTotalNum;
//    int keywordTotalNum = 0;
    int switchNum = 0;
    int [] caseNum = new int[500];

    // init the keyword util
    public static void InitKeyWordUtil(HashSet<String> keywords){
        keywords.add("auto");
        keywords.add("break");
        keywords.add("case");
        keywords.add("char");
        keywords.add("const");
        keywords.add("continue");
        keywords.add("default");
        keywords.add("do");
        keywords.add("double");
        keywords.add("else");
        keywords.add("enum");
        keywords.add("extern");
        keywords.add("float");
        keywords.add("for");
        keywords.add("goto");
        keywords.add("if");
        keywords.add("int");
        keywords.add("long");
        keywords.add("register");
        keywords.add("return");
        keywords.add("short");
        keywords.add("signed");
        keywords.add("sizeof");
        keywords.add("static");
        keywords.add("struct");
        keywords.add("switch");
        keywords.add("typedef");
        keywords.add("union");
        keywords.add("unsigned");
        keywords.add("void");
        keywords.add("volatile");
        keywords.add("while");
    }
    // check if char c is 'a' to 'z'
    public static boolean IsWord(char c){
        return c > 'a' && c < 'z';
    }

    public static void HandleLine(String line, HashSet <String> keywords){
        int lineLen = line.length();
        int headIndex = 0;
        int endIndex = 0;
        boolean inWord = false;
        for (int i = 0; i < lineLen; i++){
            if(IsWord(line.charAt(i))){
                if(!inWord){
                    headIndex = i;
                    inWord = true;
                }
            }else{
                if(inWord){
                    endIndex = i;
                    String currentWord = line.substring(headIndex, endIndex);
                    if(currentWord.equals("else")){
                        // check if the "else" follows a " if" (a "else if")
                        if(line.substring(headIndex, endIndex+3).equals("else if")){
                            keywordTotalNum += 2;
                            // 这里还要写关于if elseif else 的栈操作
                        }else{
                            keywordTotalNum++;
                        }
                    }else{
                        for(String str:keywords){
                            if(currentWord.equals(str)){
                                keywordTotalNum++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        HashSet <String> keywords = new HashSet<String>();
        InitKeyWordUtil(keywords);

        // read file path and requirement level from console
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));

        String filePath;
        System.out.println("Enter the path of file.");
        filePath = conReader.readLine();
        System.out.println("The file is :"+filePath);

        int requireLevel;
        System.out.println("Enter the level of requirement:");
        requireLevel = conReader.read();
        System.out.println("The requirement level is "+requireLevel);

        // read line by line from ordered file
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        while(line != null){
//            System.out.println(line);
            HandleLine(line,keywords);
//            System.out.println(keywordTotalNum);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();

        System.out.println(keywordTotalNum);
    }
}
