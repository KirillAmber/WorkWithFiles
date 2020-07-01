import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Update_with_UpperCase {
    public static void main(String[] args) throws IOException {

        File newDirectory = new File("update_with_UpperCase");
        newDirectory.mkdir();
        File newFile = new File(newDirectory + "\\" + "javaclass.java");
        newFile.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));

        bufferedWriter.write("public class someClass {\n" +
                "    private String name;\n" +
                "    private int id;\n" +
                "    public someClass(){\n" +
                "        name = null;\n" +
                "        id = -1;\n" +
                "    }\n" +
                "    public someClass(String name, int id){\n" +
                "        this.name = name;\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "    public String toString(){\n" +
                "        return id + \" \" + name;\n" +
                "    }\n" +
                "}");
        bufferedWriter.close();
        String line = "";
        String newText = "";
        Pattern pattern;
        Matcher matcher;
        while((line=bufferedReader.readLine())!=null){
            pattern = Pattern.compile("[a-zA-Z][a-zA-Z][a-zA-Z].[a-zA-Z]*");
            matcher = pattern.matcher(line);
            if(matcher.find()) {
                newText += matcher.replaceAll(matcher.group().toUpperCase()) + '\n';
            }
            else{
                newText += line + '\n';
            }

        }
        bufferedReader.close();
        bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        bufferedWriter.write(newText);
        bufferedWriter.close();

    }
}
