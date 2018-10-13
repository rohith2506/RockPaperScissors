package com.strategygames.rockpaperscissors;

import java.util.Scanner;

public class Utils {
    public static int GetHumanChoice(int MinLimit, int MaxLimit) {
        Scanner scanner = new Scanner(System.in);
        boolean ValidInput = false;
        int HumanChoice = -1;
        do {
            System.out.print("Enter a number: ");
            if(scanner.hasNextInt()) {
                HumanChoice = scanner.nextInt();
                if(HumanChoice >= MinLimit && HumanChoice <= MaxLimit) {
                    ValidInput = true;
                }
                if(!ValidInput) {
                    System.out.println("Invalid choice. Please choose a number between [ " + MinLimit + " - " + MaxLimit + " ]");
                }
            } else {
                scanner.nextLine();
                System.out.println("Invalid Entry. Please Enter Valid Integer Value");
            }
        } while(!ValidInput);
        return HumanChoice;
    }
}
