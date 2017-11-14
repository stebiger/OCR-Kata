package de.oc.hg.dojo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App 
{


    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ocr-examples.txt"));
        List<String> numberLine = new ArrayList<String>();
        numberLine.add(br.readLine());
        numberLine.add(br.readLine());
        numberLine.add(br.readLine());

        for (int nums = 0; nums < 9; nums++) {
            StringBuilder number = new StringBuilder();
            for (int line = 0; line < 3; line++) {
                for (int pos = nums * 3; pos < (nums * 3) + 3; pos++) {
                    number.append(numberLine.get(line).charAt(pos));
                }
            }

            System.out.println(number.toString());

        }
    }

}
