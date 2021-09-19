import java.io.*;

public class EE308_Lab2 {
    public static void main(String[] args) throws IOException {
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

//        String filePath = "C:\\Users\\sazic\\Desktop\\Y3_1\\EE308 SE\\lab\\LAB2\\test_file.c";

        // read line by line from ordered file
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
