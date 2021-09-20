package EE308_Lab2;

import java.io.*;
import java.util.HashSet;

public class EE308_Lab2 {
    static int keywordTotalNum = 0;
    static int switchNum = 0;
    static int [] caseNum = new int[500];
    static int elseifNum = 0;
//    static boolean elseifFlag = false;
    static int elseNum = 0;
    static int [] ifelseStack = new int [500];
//    static int [] positionArray = new int [500];
    static int stackLen = 0;


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
        return c >= 'a' && c <= 'z';
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
//                    System.out.println(currentWord);
                    switch (currentWord){
                        case "if":
                            keywordTotalNum++;
                            ifelseStack[++stackLen] = 1;
//                            System.out.println("***");
//                            ifelseArray[++arrayLen] = 1;
//                            positionArray[arrayLen] = headIndex;
                            break;
                        case "else":
                            if(line.substring(headIndex, endIndex+3).equals("else if")){
                                keywordTotalNum ++;
//                                System.out.println("***");
//                                ifelseArray[++arrayLen] = 1;
//                                positionArray[arrayLen] = headIndex;
//                                if(! elseifFlag){
//                                    elseifFlag = true;
//                                    elseifNum++;
//                                }
                                // 这里还要写关于if elseif else 的栈操作
                            }else{
                                keywordTotalNum++;
//                                System.out.println("***");
                                elseNum++;
//                                elseifFlag = false;
                            }
                            break;
                        case "switch":
                            keywordTotalNum++;
//                            System.out.println("***");
                            switchNum++;
                            break;
                        case "case":
                            keywordTotalNum++;
//                            System.out.println("***");
                            caseNum[switchNum]++;
                            break;
                        default:
                            for(String str:keywords){
                                if(currentWord.equals(str)){
                                    keywordTotalNum++;
//                                    System.out.println("***");
                                    break;
                            }
                        }
                    }
                    inWord = false;
                    i = endIndex;


//                    if(currentWord.equals("else")){
//                        // check if the "else" follows a " if" (a "else if")
//                        if(line.substring(headIndex, endIndex+3).equals("else if")){
//                            keywordTotalNum += 2;
//                            // 这里还要写关于if elseif else 的栈操作
//                        }else{
//                            keywordTotalNum++;
//                        }
//                    }else if(currentWord.equals("")){
//                    }else{
//                        for(String str:keywords){
//                            if(currentWord.equals(str)){
//                                keywordTotalNum++;
//                                break;
//                            }
//                        }
//                    }
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
//        System.out.println("The file is :"+filePath);

        int requireLevel;
        System.out.println("Enter the level of requirement:");
        requireLevel = conReader.read()-'0';
        while(requireLevel != 1 && requireLevel != 2 && requireLevel != 3 && requireLevel != 4){
            System.out.println("Invalid requirement level! The requirement level should be 1~4");
            System.out.println("Enter the level of requirement:");
            requireLevel = conReader.read();
        }
//        System.out.println("The requirement level is "+requireLevel);

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

        System.out.println("total num:"+keywordTotalNum);
        if(requireLevel >= 2){
            System.out.println("switch num:"+switchNum);
            System.out.print("case num:");
            for(int i = 1; i <= switchNum; i++){
                System.out.print(caseNum[i]+" ");
            }
        }
        if(requireLevel >= 3){
            System.out.println("\nif-else num:"+(elseNum-elseifNum));
        }
        if(requireLevel == 4){
            System.out.println("if-elseif-else num:"+elseifNum);
        }
    }
}
