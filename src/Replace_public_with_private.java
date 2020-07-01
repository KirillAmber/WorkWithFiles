import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace_public_with_private {
    public static void main(String[] args) throws IOException {
        File newDirectory = new File("replace_public_with_private");
        newDirectory.mkdir();
        File newFile = new File(newDirectory + "\\" + "javaclass.java");
        newFile.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));

        bufferedWriter.write("public class someClass {\n" +
                "    private String name;\n" +
                "    private int id;\n" +
                "    public someClass()public{\n" +
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
        String originalWord = "public";
        String anotherWord = "private";
        int indexOfOriginalWord;
        while((line = bufferedReader.readLine())!=null){
            indexOfOriginalWord = line.indexOf(originalWord);
            if(indexOfOriginalWord!=-1){
                /*Pattern pattern = Pattern.compile("[p]?[u]?[b]?[l]?[i]?[c]?");
                Matcher matcher = pattern.matcher(line);*/
                    newText += line.replaceAll("([p][u][b][l][i][c])", anotherWord);
                    newText += "\n";
            }
            else
                newText += line + "\n";
        }
        bufferedReader.close();

        bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        bufferedWriter.write(newText);
        bufferedWriter.close();

    }
}
