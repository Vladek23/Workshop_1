package pl.coderslab.GuessingNumbers2;

import java.util.Scanner;

public class GuessingNumbers2 {
    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę od 0 do 1000, " +
                "a ja ją zgadnę w max. 10 próbach");
        int min = 0;
        int max = 1000;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; ) {
            int guess = (max - min) / 2 + min;
            System.out.println("Próba " + i + ". Zgaduję: " + guess);
            String line = scanner.nextLine();
            if (line.equals("zgadłeś")) {
                System.out.println("Wygrałem!");
                break;
            } else if (line.equals("za dużo")) {
                max = guess;
                i++;
            } else if (line.equals("za mało")) {
                min = guess;
                i++;
            } else {
                System.out.println("Nie oszukuj!");
            }
        }
    }

}
