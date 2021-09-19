import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> keywords = new HashSet<String>();
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

        for(String i : keywords){
            if(i.equals("if") || i.equals("else")){
                System.out.println(i);
            }
        }
    }
}
