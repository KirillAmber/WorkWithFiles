import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Sort_numbers_in_File {
    public static void main(String[] args) throws IOException {
        File newDirectory = new File("sort_numbers_in_file");

        if(newDirectory.mkdir())
            System.out.println("Directory is created");
        else if(newDirectory.exists())
            System.out.println("The directory was not created, because it has already been created");

        File newFile = new File("sort_numbers_in_file\\sort_numbers.txt");

        if(newFile.createNewFile())
            System.out.println("File is created");
        else if(newFile.exists())
            System.out.println("The file was not created, because it has already been created");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<10; i++) {
            bufferedWriter.write(String.valueOf(random.nextInt(100)) + " ");
        }
        bufferedWriter.close();
        String line = "";
        StringTokenizer stringTokenizer;
        while((line = bufferedReader.readLine())!=null) {
            stringTokenizer = new StringTokenizer(line, " ");
            while(stringTokenizer.hasMoreTokens()){
                list.add(Integer.valueOf(stringTokenizer.nextToken()));
            }
        }
        list.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(list);
        bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        for(int element:list){
            bufferedWriter.write(String.valueOf(element)+ " ");
        }
        bufferedWriter.close();
        bufferedReader.close();


    }
}
