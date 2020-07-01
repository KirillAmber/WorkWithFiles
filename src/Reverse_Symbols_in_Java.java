import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class Reverse_Symbols_in_Java {
    public static void main(String[] args) throws IOException {
        File newDirectory = new File("reverse_symbols_in_java");
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

        Stack<Character> stack = new Stack<>();
        String line = "";
        String newText = "";
        while((line = bufferedReader.readLine())!=null){
            for(char symbol:line.toCharArray()){
                stack.add(symbol);
            }
            while(!stack.empty()){
                newText += stack.pop();
            }
            newText += '\n';
        }
        bufferedReader.close();
        bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        bufferedWriter.write(newText);
        bufferedWriter.close();
    }
}
