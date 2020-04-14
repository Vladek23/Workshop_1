package pl.coderslab.GuessingNumbers;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        int goal = random.nextInt(100) + 1;
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Guess the number: ");
                String line = scanner.nextLine();
                input = Integer.parseInt(line);
                if (input > goal) {
                    System.out.println("Too much!");
                } else if (input < goal) {
                    System.out.println("Not enough!");
                }
            } catch (NumberFormatException e) {
                System.err.println("It's not the number");
            }
        } while (goal != input);
        System.out.println("You got the right number :)");
    }
}
