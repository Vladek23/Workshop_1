package pl.coderslab.LottoSimulator;

import java.util.*;

public class LottoSimulator {
    public static void main(String[] args) {
        lotto();

    }

    static void lotto () {
        Scanner input = new Scanner (System.in);
        final int howMany=6;
        int [] tab = new int [howMany];
        int [] tabComp = new int [howMany];
        System.out.println("Witaj w symulatorze Lotto! Podaj swoje liczby: ");
        while(true) {
            try {
                StringTokenizer st = new StringTokenizer(input.nextLine(), " ");
                int check=0;
                for(int i=0; i<howMany;i++) {
                    check = Integer.parseInt(st.nextToken());
                    if(!(check<=49 && check >0)) throw new Exception("Podałeś niewłaściwe liczby!");
                    for(int j=0; j<i; j++) {
                        if(check==tab[j]) throw new Exception ("Podałeś powtarzające się liczby!");
                        else {
                            tab[i]=check;
                        }
                    }
                }
                break;
            }
            catch (NoSuchElementException e) {
                System.out.println("Podałeś błędną ilość liczb! Podaj 6 liczb:");
            }
            catch(NumberFormatException e) {
                System.out.println("Podałeś niewłaściwe dane! Spróbuj jeszcze raz:");
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        int hits [] = new int [6];
        int index=0;
        int howManyHits=0;
        Random rand=new Random ();
        System.out.print("Losowanie: ");
        for(int i=0; i<howMany; i++) {
            tabComp[i]= rand.nextInt(49)+1;
            System.out.print(tabComp[i] + ", ");
        }
        System.out.println("");
        int [] zero = {0,0,0,0,0,0};
        for (int subTab: tab)
            for (int subTabComp: tabComp)
                if(subTab==subTabComp) {
                    hits [index]=subTab;
                    index++;
                }
        if (Arrays.equals(hits, zero)) {
            System.out.print("Nie trafiłeś. Spróbuj szczęścia następnym razem!");
        }
        else {
            System.out.print("Trafiłeś: ");
            for (int i=0; i<howMany; i++)
                if(hits[i]!=0) {
                    howManyHits++;
                    System.out.print(hits[i] + " ");
                }
            System.out.println();
            if (howManyHits<3) System.out.println("Niestety! Spróbuj następnym razem.");
            if (howManyHits==3) System.out.println("Trafiłeś trójkę!");
            if (howManyHits==4) System.out.println("Trafiłeś czwórkę!");
            if (howManyHits==5) System.out.println("Trafiłeś piątkę!");
            if (howManyHits==6) System.out.println("Trafiłeś szóstkę! Gratulacje!");
        }
        input.close();
    }
}
