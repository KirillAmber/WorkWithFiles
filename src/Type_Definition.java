import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Type_Definition {
    public static void main(String[] args) throws IOException {
        File newDirectory = new File("type_definition");
        newDirectory.mkdir();
        File newFile = new File(newDirectory + "\\" + "text.txt");
        newFile.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));
        bufferedWriter.write("Огурец 50 12 10.5\n" +
                "а слово г a | 0.1032 \n" +
                "5 60 на 6000 круг ? ложка ! % l s\n" +
                "Евгений Онегин д 10023.5126126\n");
        bufferedWriter.close();

        String line = "";
        ArrayList<Character> characterArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;

        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);

            pattern = Pattern.compile("(?<![.])\\b[0-9]+\\b(?![.])"); // integer
            matcher = pattern.matcher(line);
            while(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                while(stringTokenizer.hasMoreTokens()){
                    integerArrayList.add(Integer.valueOf(stringTokenizer.nextToken()));
                }
            }
            pattern = Pattern.compile("\\p{Punct}"); // character
            matcher = pattern.matcher(line);
            while(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                while(stringTokenizer.hasMoreTokens()){
                    characterArrayList.add(stringTokenizer.nextToken().charAt(0));
                }
            }
            pattern = Pattern.compile("[а-яёА-Я]+"); // string
            matcher = pattern.matcher(line);
            while(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                while(stringTokenizer.hasMoreTokens()){
                    stringArrayList.add(stringTokenizer.nextToken());
                }
            }

            pattern = Pattern.compile("\\b[0-9]+[.][0-9]+\\b"); // double
            matcher = pattern.matcher(line);
            while(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                while(stringTokenizer.hasMoreTokens()){
                    doubleArrayList.add(Double.valueOf(stringTokenizer.nextToken()));
                }
            }

        }
        bufferedReader.close();
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while(!isEnd) {
                System.out.println("Enter a data type to display all data of this type(character/string/integer/double)");
                 if(!(scanner.hasNext("character") || scanner.hasNext("string")
                    || scanner.hasNext("integer") || scanner.hasNext("double"))) {
                    break;
                 }
                if (scanner.hasNext("character")) {
                    System.out.println(characterArrayList);
                    System.out.println("Continue?(y/n)");
                    scanner.next();
                    while (true) {
                        if (scanner.hasNext("y")) {
                            break;
                        }
                        if (scanner.hasNext("n")) {
                            isEnd = true;
                            break;
                        }
                        if(!(scanner.hasNext("y") || scanner.hasNext("n"))){
                            scanner.next();
                        }
                    }
                    scanner.next();
                    continue;
                }
                if (scanner.hasNext("string")) {
                    System.out.println(stringArrayList);
                    System.out.println("Continue?(y/n)");
                    scanner.next();
                    while (true) {
                        if (scanner.hasNext("y")) {
                            break;
                        }
                        if (scanner.hasNext("n")) {
                            isEnd = true;
                            break;
                        }
                        if(!(scanner.hasNext("y") || scanner.hasNext("n"))){
                            scanner.next();
                        }
                    }
                    scanner.next();
                    continue;
                }
                if (scanner.hasNext("integer")) {
                    System.out.println(integerArrayList);
                    System.out.println("Continue?(y/n)");
                    scanner.next();
                    while (true) {
                        if (scanner.hasNext("y")) {
                            break;
                        }
                        if (scanner.hasNext("n")) {
                            isEnd = true;
                            break;
                        }
                        if(!(scanner.hasNext("y") || scanner.hasNext("n"))){
                            scanner.next();
                        }
                    }
                    scanner.next();
                    continue;
                }
                if (scanner.hasNext("double")) {
                    System.out.println(doubleArrayList);
                    System.out.println("Continue?(y/n)");
                    scanner.next();
                    while (true) {
                        if (scanner.hasNext("y")) {
                            break;
                        }
                        if (scanner.hasNext("n")) {
                            isEnd = true;
                            break;
                        }
                        if(!(scanner.hasNext("y") || scanner.hasNext("n"))){
                            scanner.next();
                        }
                    }
                    scanner.next();
                }
        }
        scanner.close();
    }
    public static void continue_or_no(){

    }
}
