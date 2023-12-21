import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String FILE_NAME = "C:\\users\\Solibr\\Desktop\\tasklist.csv";

    public static void main(String[] args) {
        List<String[]> text = new ArrayList<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(FILE_NAME));
            text = reader.readAll();
            int sum = 0;
            for (String[] line : text) {
                //Arrays.stream(line).forEach(x -> System.out.print(x + " "));
                String word = line[4];
                word = word.replaceAll("КБ", "").replaceAll(" ", "").replaceAll(" ", "");

                sum += Integer.parseInt(word);
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
