package de.oc.hg.dojo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final char UNDERSCORE = '_';
    private static final char PIPE = '|';
    private static final char EMPTY = ' ';

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ocr-examples.txt"));
        List<String> numberLine = new ArrayList<String>();
        numberLine.add(br.readLine());
        numberLine.add(br.readLine());
        numberLine.add(br.readLine());

        for(int nums=0; nums < 9; nums++) {
            System.out.println();
            StringBuilder number = new StringBuilder();
            for (int line = 0; line < 3; line++) {
                for (int pos = nums*3; pos < (nums*3)+3; pos++) {
                    number.append(numberLine.get(line).charAt(pos));
                }
            }

        String num = number.toString();
        System.out.print(num + " = ");

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(int pos=1; pos < num.length(); pos++) {
            switch(pos+1) {
                case 2:
                    if (EMPTY == num.charAt(pos)) {
                        // 1,4
                        numbers.remove(new Integer(0));
                        numbers.remove(new Integer(2));
                        numbers.remove(new Integer(3));
                        numbers.remove(new Integer(5));
                        numbers.remove(new Integer(6));
                        numbers.remove(new Integer(7));
                        numbers.remove(new Integer(8));
                        numbers.remove(new Integer(9));
                    } else if(UNDERSCORE == num.charAt(pos)) {
                        numbers.remove(new Integer(1));
                        numbers.remove(new Integer(4));
                    }
                    break;
                case 4:
                    if (EMPTY == num.charAt(pos)) {
                        numbers.remove(new Integer(0));
                        numbers.remove(new Integer(4));
                        numbers.remove(new Integer(5));
                        numbers.remove(new Integer(6));
                        numbers.remove(new Integer(8));
                        numbers.remove(new Integer(9));
                    } else if(PIPE == num.charAt(pos)) {
                        numbers.remove(new Integer(1));
                        numbers.remove(new Integer(2));
                        numbers.remove(new Integer(3));
                        numbers.remove(new Integer(7));
                    }
                    break;
                case 5:
                    if (EMPTY == num.charAt(pos)) {
                        numbers.remove(new Integer(2));
                        numbers.remove(new Integer(3));
                        numbers.remove(new Integer(5));
                        numbers.remove(new Integer(6));
                        numbers.remove(new Integer(8));
                        numbers.remove(new Integer(9));
                    } else if(UNDERSCORE == num.charAt(pos)) {
                        numbers.remove(new Integer(0));
                        numbers.remove(new Integer(7));
                    }
                    break;
                case 6:
                    if(PIPE == num.charAt(pos)) {
                        numbers.remove(new Integer(5));
                        numbers.remove(new Integer(6));
                    } else if(EMPTY == num.charAt(pos)) {
                        numbers.remove(new Integer(8));
                        numbers.remove(new Integer(9));
                    }
                    break;
                case 7:
                    if(PIPE == num.charAt(pos)) {
                        numbers.remove(new Integer(5));
                        numbers.remove(new Integer(3));
                        numbers.remove(new Integer(9));
                    } else if(EMPTY == num.charAt(pos)) {
                        numbers.remove(new Integer(2));
                        numbers.remove(new Integer(6));
                        numbers.remove(new Integer(8));
                    }
                    break;
            }

            if(numbers.size() == 1) {
                System.out.print(numbers.get(0));
                break;
            }

        }

    }
    }

}
