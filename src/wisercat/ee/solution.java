package wisercat.ee;


import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class solution {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fr);
        String elementsFromFile = br.readLine();  // all elements from file (read a file)
        String onlyNumbers = elementsFromFile.substring(1, elementsFromFile.length() - 1);
        String[] array = onlyNumbers.split(", ");
        System.out.println("Prepared array: " + Arrays.toString(array)); // prepared array
        for (int i = 0; i < array.length / 2; i++) {  // swap elements, example: [1,2,3,4] -> [4,2,3,1] -> [4,3,2,1]
            String elements = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = elements;
        }
        System.out.println("Reversed array: " + Arrays.toString(array)); // reversed array
        File file = new File("file.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(Arrays.toString(array));
        pw.close();

    }
}