package wisercat.ee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class solution {

    public static void main(String[] args) {
        String line = "";
        List<String> myList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt")); //  read the file
            line += br.readLine(); // [1,2,3,4...10];
            String line2 = line.substring(1, line.length() - 1); // 1,2,3,4,5,6,7... 10
            List<String> divide = List.of(line2.replaceAll(" ", "").split(",")); // [1,2,3...10]
            myList.addAll(divide); // [1,2,3,4...10]
            System.out.println(myList);
            for (int i = myList.size() - 1; i > -1; i--) {
                String reverseNumbers = myList.get(i);
                myList.remove(i);
                myList.add(reverseNumbers);
            }

            System.out.println(myList);
            File file = new File("file.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.println(myList);
            pw.close();


        } catch (IOException e) {
            System.out.println("Error" + e);

        }
    }
}
