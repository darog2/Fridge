package com.dungeon;

import java.util.Scanner;

public class InputUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int readInt(String comment) {
        String line;
        String fullLine;
        boolean isCorrect;
        do {
            System.out.print(comment + ": ");
            fullLine = SCANNER.nextLine();
            if (fullLine.startsWith("-") || fullLine.startsWith("+")) {
                line = fullLine.substring(1);
            } else {
                line = fullLine;
            }
            isCorrect = true;
            if (line.isEmpty()) {
                isCorrect = false;
            } else {
                char[] symbols = line.toCharArray();
                for (int i = 0; i < symbols.length; i++) {
                    if (!Character.isDigit(symbols[i])) {

                        isCorrect = false;
                        break;
                    }
                }
            }
            if (!isCorrect) {
                System.out.println("incorrect input, try again");
            }
        } while (!isCorrect);
        return Integer.parseInt(fullLine);
    }
    public static String readLine(String comment) {
        System.out.print(comment + ": ");
        return SCANNER.nextLine();

    }
}
