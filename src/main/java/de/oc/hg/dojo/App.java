package de.oc.hg.dojo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App
{

    private static final char UNDERSCORE = '_';
    private static final char PIPE = '|';
    private static final char EMPTY = ' ';

    public static void main( String[] args ) throws IOException {
        Scanner scan = new Scanner(new FileInputStream("ocr-examples.txt"));
        while (scan.hasNextLine()) {
            List<String> numberLine = new ArrayList<String>();
            numberLine.add(scan.nextLine());
            numberLine.add(scan.nextLine());
            numberLine.add(scan.nextLine());
            numberLine.add(scan.nextLine());


            StringBuilder bankaccount = new StringBuilder();
            for (int nums = 0; nums < 9; nums++) {
                System.out.println();
                StringBuilder number = new StringBuilder();
                for (int line = 0; line < 3; line++) {
                    for (int pos = nums * 3; pos < (nums * 3) + 3; pos++) {
                        number.append(numberLine.get(line).charAt(pos));
                    }
                }

                String num = number.toString();
                System.out.print(num + " = ");

                ArrayList<Integer> availableNumbers = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));


                for (int pos = 1; pos < num.length(); pos++) {
                    switch (pos + 1) {
                        case 2:
                            if (EMPTY == num.charAt(pos)) {
                                // 1,4
                                availableNumbers.remove(new Integer(0));
                                availableNumbers.remove(new Integer(2));
                                availableNumbers.remove(new Integer(3));
                                availableNumbers.remove(new Integer(5));
                                availableNumbers.remove(new Integer(6));
                                availableNumbers.remove(new Integer(7));
                                availableNumbers.remove(new Integer(8));
                                availableNumbers.remove(new Integer(9));
                            } else if (UNDERSCORE == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(1));
                                availableNumbers.remove(new Integer(4));
                            }
                            break;
                        case 4:
                            if (EMPTY == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(0));
                                availableNumbers.remove(new Integer(4));
                                availableNumbers.remove(new Integer(5));
                                availableNumbers.remove(new Integer(6));
                                availableNumbers.remove(new Integer(8));
                                availableNumbers.remove(new Integer(9));
                            } else if (PIPE == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(1));
                                availableNumbers.remove(new Integer(2));
                                availableNumbers.remove(new Integer(3));
                                availableNumbers.remove(new Integer(7));
                            }
                            break;
                        case 5:
                            if (EMPTY == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(2));
                                availableNumbers.remove(new Integer(3));
                                availableNumbers.remove(new Integer(5));
                                availableNumbers.remove(new Integer(6));
                                availableNumbers.remove(new Integer(8));
                                availableNumbers.remove(new Integer(9));
                            } else if (UNDERSCORE == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(0));
                                availableNumbers.remove(new Integer(7));
                            }
                            break;
                        case 6:
                            if (PIPE == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(5));
                                availableNumbers.remove(new Integer(6));
                            } else if (EMPTY == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(8));
                                availableNumbers.remove(new Integer(9));
                            }
                            break;
                        case 7:
                            if (PIPE == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(5));
                                availableNumbers.remove(new Integer(3));
                                availableNumbers.remove(new Integer(9));
                            } else if (EMPTY == num.charAt(pos)) {
                                availableNumbers.remove(new Integer(2));
                                availableNumbers.remove(new Integer(6));
                                availableNumbers.remove(new Integer(8));
                            }
                            break;
                    }

                    if (availableNumbers.size() == 1) {
                        System.out.print(availableNumbers.get(0));
                        bankaccount.append(availableNumbers.get(0));
                        break;
                    }

                }

            }
            System.out.print("\nBank account number: " + bankaccount.toString());
            int sum = 0;
            for(int i=0; i < bankaccount.toString().length(); i++) {
                sum += (9-i)*new Integer(bankaccount.toString().charAt(i));
            }
            int res = sum % 11;
            if(res != 0) {
                System.out.print(" ERR");
            }
            System.out.print("\n");
        }
    }

}