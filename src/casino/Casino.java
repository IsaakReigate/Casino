package casino;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;

public class Casino {

    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        
        customerAccount accountOne = new customerAccount("Isaak", 42069);
        menu();

    }

    public static void menu() {

        //Welcomes the user. Select 1 of 4 options.
        System.out.println("|---------Welcome to the Casino---------|");
        while (true) {
            try {
                System.out.println("  TYPE AN OPTION:\n1:MAKE AN ACCOUNT\n2:PLAY ROULETTE\n3:PLAY SLOT MACHINE\n4:PLAY DICE");
                int chosenOption = input.nextInt();
                switch (chosenOption) {
                    case (1):
                        createaccountMethod();
                        break;
                    case (2):
                        rouletteMethod();
                        break;
                    case (3):
                        slotmachineMethod();
                        break;
                    case (4):
                        diceMethod();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error occured, please try again:");
            }
        }
    }

    public static int betAmount() {
        boolean validAmount = false;
        int userBalanceTest = 1000;

        //Code to verify bet amount is a full, positive amount within the user's budget.
        while (validAmount == false) {
            try {
                System.out.println("How many bits would you like to bet?");
                int betAmount = input.nextInt();
                if (betAmount > 0 && betAmount <= userBalanceTest) {
                    validAmount = true;
                    break;
                } else {
                    System.out.println("You do not have that many bits.");
                }
            } catch (Exception e) {
                System.out.println("You did not enter a full valid amount. Please do not try to cheat the system.");
                System.exit(0);
            }
        }
        return validAmount;
    }

    public static void createaccountMethod() {
        System.out.println("Enter a new username, symbols not allowed: ");
        String newUserName = input.next();
        //Creates a text file with username and currency. Separate from username and password security.
        try {
            File listOfAccounts = new File("D:/listOfAccounts.txt");//Path of the file. 
            FileWriter fileW = new FileWriter(listOfAccounts, true);
            BufferedWriter bufferedW = new BufferedWriter(fileW);

            bufferedW.write(newUserName + ",0");
            bufferedW.newLine();
            bufferedW.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void rouletteMethod() {
        boolean won = false;

                ///VERIFY USER NAME
        System.out.println("What is your username?");
        String enteredUsername = input.next();

        int bet = betAmount();

        //Sets up arrays for black and red roulette wheel. Excluding green 0.
        String redNumbers = ("1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36");
        String blackNumbers = ("2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35");
        //Selects a number from 0-36. Casts to string.
        int numberLandedOn = rand.nextInt(36);
        String stringNumberLandedOn = String.valueOf(numberLandedOn);

        System.out.println("Choose a colour to bet on. Landing on green means 14x :\n1:Black\n2:Red\n3:Green");
        int colourChosen = input.nextInt();
        switch (colourChosen) {
            case (1):
                if (blackNumbers.contains(stringNumberLandedOn)) {
                    System.out.println("You have won!\n");
                    won = true;
                } else {
                    System.out.println("You have lost!\n");
                    System.out.println("The number was: " + stringNumberLandedOn);
                    if (stringNumberLandedOn.equals("0")) {
                        System.out.println("Which was green.\n");
                    } else {
                        System.out.println("Which was red.\n");
                    }
                }
                break;

            case (2):
                if (redNumbers.contains(stringNumberLandedOn)) {
                    System.out.println("You have won!\n");
                    won = true;
                } else {
                    System.out.println("You have lost!\n");
                    System.out.println("The number was: " + stringNumberLandedOn);
                    if (stringNumberLandedOn.equals("0")) {
                        System.out.println("Which was green.\n");
                    } else {
                        System.out.println("Which was black.\n");
                    }
                }
                break;

            case (3):
                if (stringNumberLandedOn == "0") {
                    System.out.println("You have won!\n");
                    won = true;
                } else {
                    System.out.println("You have lost!\n");
                    System.out.println("The number was: " + stringNumberLandedOn);
                    if (redNumbers.contains(stringNumberLandedOn)) {
                        System.out.println("Which was red.\n");
                    } else {
                        System.out.println("Which was black.\n");
                    }
                }
                break;
        }
        if (won == true) {

        }

    }

    public static void slotmachineMethod() {
        System.out.println("magic");
    }

    public static void diceMethod() {

    }

}
