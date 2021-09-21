package EE308_Lab2;

import java.io.*;
import java.util.HashSet;

public class EE308_Lab2 {
    static int keywordTotalNum = 0;
    static int switchNum = 0;
    static int [] caseNum = new int[500];
    static int elseifNum = 0;
//    static boolean elseifFlag = false;
//    static int [] positionArray = new int [500];
    static int elseNum = 0;
    static int [] ifelseStack = new int [5000];
    static int stackLen = 0;
    static boolean annotationFlag = false;

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

    public static void WorkOnStack(){
        int [] currentStack = new int [4000];
        int now=0;
        for(int i = 1 ; i <= stackLen ; i++){
            switch (ifelseStack[i]){
                case 3:
                    if(currentStack[now-1] == 2){
                        now -= 4;
                        if(currentStack[now] != 0){
                            currentStack[++now] = 0;
                        }
                        elseifNum++;
                    }else if(currentStack[now-1] == 1){
                        now -= 2;
                        if(currentStack[now] != 0){
                            currentStack[++now] = 0;
                        }
                        elseNum++;
                    }
                case 2:
                    if(currentStack[now] != 0 || currentStack[now-1] != 2){
                        currentStack[++now] = 2;
                    }
                    break;
                case 9:
                    if(currentStack[now] == 6){
                        if(currentStack[now-1] != 0){
                            currentStack[now] = 0;
                        }else{
                            now--;
                        }
                    }else if(currentStack[now] == 0 && currentStack[now-1] == 6){
                        if(currentStack[now-2] != 0){
                            currentStack[now-1] = 0;
                        }else{
                            now -= 2;
                        }
                    }
                    break;
                case 0:
                    if(currentStack[now] != 0){
                        currentStack[++now] = 0;
                    }
                    break;
                case 1:
                    currentStack[++now] = ifelseStack[i];
                    break;
                case 6:
                    currentStack[++now] = ifelseStack[i];
                    break;
            }
        }
    }

    public static String DeleteLineAnnotation(String str){
        for(int i = 0; i < str.length() ;i++){
            if(str.charAt(i) == '/' && str.charAt(i) == '/'){
                return str.substring(0,i);
            }
        }
        return str;
    }

    public static String DeleteBarAnnotation(String str){
        StringBuilder sb = new StringBuilder(200);
        for(int i = 0; i < str.length() ;i++){
            if(!annotationFlag){
                if(str.charAt(i) == '/' && str.charAt(i) == '*'){
                    annotationFlag = true;
                }else{
                    sb.append(str.charAt(i));
                }
            }else{
                if(str.charAt(i) == '*' && str.charAt(i) == '/'){
                    i++;
                    annotationFlag = false;
                }
            }
        }
        return sb.toString();
    }

    public static String DeleteInsideString(String str){
        StringBuilder sb = new StringBuilder(200);
        for(int i = 0; i < str.length() ;i++){
            if(!annotationFlag){
                if(str.charAt(i) == '"' && str.charAt(i) == '"'){
                    annotationFlag = true;
                    i++;
                }else{
                    sb.append(str.charAt(i));
                }
            }else{
                if(str.charAt(i) == '"' && str.charAt(i) == '"'){
                    i++;
                    annotationFlag = false;
                }
            }
        }
        return sb.toString();
    }


    public static void HandleLine(String line, HashSet <String> keywords){

        int headIndex = 0;
        int endIndex = 0;
        boolean inWord = false;
        line = DeleteLineAnnotation(line);
        line = DeleteBarAnnotation(line);
        line = DeleteInsideString(line);
        int lineLen = line.length();
//        System.out.println(line);
//        System.out.println(line.charAt(1));
//        int emptyTag = 0;
//        while(line.charAt(emptyTag) == ' '){
//            emptyTag++;
//        }
//        if(emptyTag != 0){
//            line = line.substring(emptyTag);
//        }
//        System.out.println(line);
//        // dealing with annotation
//        for(int i = 0; i < lineLen ; i++){
//            System.out.println(line);
//            System.out.print(i);
//            System.out.println((line.charAt(i)));
//            if(!annotationFlag){
//                if(line.charAt(i) == '/' && line.charAt(i+1) == '/'){
//                    lineLen=i;
//
////                    System.out.println(lineLen);
//
//                    break;
//                }
//                if(line.charAt(i) == '/' && line.charAt(i+1) == '*'){
//                    annotationFlag = true;
//                }
//            }else{
//                if(line.charAt(i) == '*' && line.charAt(i+1) == '/'){
//                    annotationFlag = false;
//                    line = line.substring(i+2, lineLen);
//                    lineLen -=  i;
//                }
//            }
//        }
//        if(annotationFlag) return ;
//        System.out.println(line);

//        // dealing with strings
//        int stringMark = 1;
//        while(stringMark != -1){
//            stringMark = -1;
////            System.out.println(line);
//            for(int i = 0; i < lineLen ; i++){
//                if(line.charAt(i) == '"'){
//                    if(stringMark == -1){
//                        stringMark = i;
//                    }else{
//                        line = line.substring(0,stringMark) + line.substring(i+1, lineLen);
//                        lineLen -= (i - stringMark+1);
//                        stringMark = -1;
//                    }
//                }
//            }
//        }

//        System.out.println(line);
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
                            i = endIndex;
                            break;
                        case "else":
                            if(line.substring(headIndex, endIndex+3).equals("else if")){
                                keywordTotalNum +=2;
                                ifelseStack[++stackLen] = 2;
                                i = endIndex+3;
                            }else{
                                keywordTotalNum++;
//                                while(ifelseStack[stackLen] != 2)
                                ifelseStack[++stackLen] = 3;
                                i = endIndex;
                            }
                            break;
                        case "switch":
                            keywordTotalNum++;
//                                    System.out.println("switch");
                            switchNum++;
                            i = endIndex;
                            break;
                        case "case":
//                                    System.out.println("case");
                            keywordTotalNum++;
                            caseNum[switchNum]++;
                            i = endIndex;
                            break;
                        default:
//                                    System.out.println(currentWord);
                            for(String str:keywords){
                                if(currentWord.equals(str)){
//                                            System.out.println("OK!\n");
                                    keywordTotalNum++;
                                    break;
                                }
                            }
                            i = endIndex;
                    }
                    inWord = false;
                }
            }
            switch (line.charAt(i)) {
                case '{':
                    ifelseStack[++stackLen] = 6;
                    break;
                case '}':
                    ifelseStack[++stackLen] = 9;
                    break;
                case ';':
                    if (ifelseStack[stackLen] != 0) {
                        ifelseStack[++stackLen] = 0;
                    }
                    break;
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

        int requireLevel;
        System.out.println("Enter the level of requirement:");
        requireLevel = conReader.read()-'0';
        while(requireLevel != 1 && requireLevel != 2 && requireLevel != 3 && requireLevel != 4){
            System.out.println("Invalid requirement level! The requirement level should be 1~4");
            System.out.println("Enter the level of requirement:");
            requireLevel = conReader.read();
        }

        // read line by line from ordered file
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        while(line != null){
//            System.out.println("before"+line);
            HandleLine(line,keywords);
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
            WorkOnStack();
            System.out.println("\nif-else num:"+elseNum);
        }
        if(requireLevel == 4){
//            for(int i=1;i<=stackLen;i++){
//                switch (ifelseStack[i]){
//                    case 3:
//                        System.out.print("else ");
//                        break;
//                    case 2:
//                        System.out.print("else if ");
//                        break;
//                    case 1:
//                        System.out.print("if ");
//                        break;
//                    case 0:
//                        System.out.print("; ");
//                        break;
//                    case 9:
//                        System.out.print("} ");
//                        break;
//                    case 6:
//                        System.out.print("{ ");
//                        break;
//                    default:
//                }
//            }
            System.out.println("\nif-elseif-else num:"+elseifNum);
        }
    }
}
//System.out.print(ifelseStack[i]);