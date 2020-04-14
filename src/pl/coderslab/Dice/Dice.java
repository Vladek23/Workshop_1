package pl.coderslab.Dice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dice {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String kod="";
        System.out.println("Symulacja rzutu kostką. Podaj kod kostki: ");
        kod=scan.nextLine();
        int i=0;
        try {
            while(Character.isDigit(kod.charAt(i))) {
                i++;
                if(i==kod.length()) break;
            }
            String licz=kod.substring(0,i);
            int liczba = Integer.parseInt(licz);

            i++;

            while(Character.isDigit(kod.charAt(i))) {
                i++;
                if(i==kod.length()) break;
            }
            String kostkaStr = kod.substring(licz.length()+1,i);
            int kostka = Integer.parseInt(kostkaStr);
            boolean plus;
            if(kod.charAt(i)=='+') plus=true;
            else plus=false;
            int miejsce=i;
            while(Character.isDigit(kod.charAt(i))) {
                if(i==kod.length()) break;
                i++;
            }
            int modyfikator=Integer.parseInt(kod.substring(miejsce+1));
            Random generator = new Random();
            int wynik=0;
            int los=0;
            System.out.print("Losuję: ");
            for(int k=0; k<liczba; k++) {
                los = generator.nextInt(kostka)+1;
                System.out.print(los + ", ");
                wynik += los;
            }
            System.out.println();
            if(plus) {
                wynik+=modyfikator;
                System.out.println("Rzucam " + liczba + " razy kostką o " + kostka + " ścianach i dodaję " + modyfikator + ": " + wynik);
            }
            else {
                wynik-=modyfikator;
                System.out.println("Rzucam " + liczba + " razy kostką o " + kostka + " ścianach i odejmuję " + modyfikator + ": " + wynik);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Podałeś błędny kod kostki!");
        }
        catch (NumberFormatException e) {
            System.out.println("Podałeś błędny kod kostki!");
        }
        scan.close();
    }
}
