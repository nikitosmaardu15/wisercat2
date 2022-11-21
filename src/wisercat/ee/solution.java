package wisercat.ee;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class solution {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt")); //  read the file
            line += br.readLine();
            String allElements = line.replaceAll(", ", ""); // only numbers in list
            String removeComma = allElements.replaceAll(",", ""); // [4321]
            for (int i = 1; i < removeComma.length() - 1; i++) {
                char onlyNumbers = removeComma.charAt(i); // 1 2 3 4 5
                arrayList.add(String.valueOf(onlyNumbers));
            }
            System.out.println(arrayList);
            for (int i = arrayList.size() - 1; i > -1; i--) {
                String reverseNumbers = arrayList.get(i);
                arrayList.remove(i);
                arrayList.add(reverseNumbers);
            }
            System.out.println(arrayList);
            File file = new File("file.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.println(arrayList);
            pw.close();

        } catch (IOException e) {
            System.out.println("Error" + e);

        }
    }
}
