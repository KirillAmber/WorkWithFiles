import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student_Grades {
    public static void main(String[] args) throws IOException {
        File newDirectory = new File("student_grade");
        newDirectory.mkdir();
        File newFile = new File(newDirectory + "\\" + "grades.txt");
        newFile.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));

        bufferedWriter.write("Шелякин Кирилл Александрович 5 10 10 7\n" +
                "Волков Владимир Сергеевич 5 10 8 9\n" +
                "Стёпочкин Захар Мордобоев 4 7 10 7\n" +
                "Курочкина Елена Владимировна 3 4 5 9\n" +
                "Старцева Софья Сергеевна 10 9 8 10\n" +
                "Пирожков Олег Александрович 5 6 6 10\n");
       bufferedWriter.close();

        String line = "";
        String newText = "";
        Stack<Integer> stack = new Stack<>();
        Pattern pattern;
        Matcher matcher;
        double average;
        double size;
        while((line = bufferedReader.readLine())!=null){
            pattern = Pattern.compile("\\d.+");
            matcher = pattern.matcher(line);
            if(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                average = 0;
                while(stringTokenizer.hasMoreTokens()){
                    stack.add(Integer.valueOf(stringTokenizer.nextToken()));
                }
                size = stack.size();
                for(int i = 0; i< stack.size(); i++){
                    average += stack.get(i);
                }
                if(average/size > 7){
                    pattern = Pattern.compile("[а-яёА-Я].+[а-яёА-Я]");
                    matcher = pattern.matcher(line);
                    if(matcher.find()){
                        newText += matcher.group().toUpperCase() + " ";
                        while(!stack.empty()){
                            newText += stack.pop() + " ";
                        }
                        newText += '\n';
                    }
                }
                else{
                    newText += line + '\n';
                    stack.clear();
                }
            }
        }
        bufferedReader.close();

        bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        bufferedWriter.write(newText);
        bufferedWriter.close();
    }
}
