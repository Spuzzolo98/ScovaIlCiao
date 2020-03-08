package scovailciao_07.pkg03.pkg2020;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ScovaIlCiao_07032020 {

    static int SceltaDifficolta() throws InterruptedException {
        Scanner scannervar = new Scanner(System.in);
        int difficoltascelta = 0;
        System.out.println("Benvenuto in 'Scova la matrice'!");
        TimeUnit.SECONDS.sleep(0);
        System.out.println("per cominciare, scegli la difficoltà.");
        resetdifficolta:
        TimeUnit.SECONDS.sleep(0);
        while (difficoltascelta > 4 || difficoltascelta < 1) {
            System.out.println("facile (1)\n" + "media(2)\n" + "difficile(3)\n" + "DoomSlayerMiPuòFareUnaCarezza™(4)");
            System.out.print("-");
            difficoltascelta = scannervar.nextInt();
            if (difficoltascelta > 4 || difficoltascelta < 1) {
                System.out.println("errore!");
            }
        }
        return difficoltascelta;
    }

    static int DifficoltàMatrice(int difficoltascelta) {
        int difficolta = 0;
        switch (difficoltascelta) {
            case 1:
                difficolta = 10;
                break;
            case 2:
                difficolta = 20;
                break;
            case 3:
                difficolta = 40;
                break;
            case 4:
                difficolta = 80;
                break;
        }
        return difficolta;
    }

    static int RiempimentoMatrice(int matrice[][], int xmatrice, int ymatrice, int difficolta) {
        Random randomvar = new Random();
        int a = randomvar.nextInt(xmatrice), bi = randomvar.nextInt(ymatrice);
        int rirornox = 0, ritornoy = 0;
        matrice[a][bi] = 100;
        rirornox = a * 100;
        ritornoy = bi;
        rirornox = rirornox + ritornoy;
        return rirornox;
    }

    static int aiutiintegrati() {
        Scanner scannervar = new Scanner(System.in);
        int sceltaaiuti = 0;
        System.out.println("bene, ora che abbiamo scelto la difficoltà non rimangono che \n le impostazioni. Vorresti usare gli aiuti integrati?");

        System.out.println("-Sì, sono una checca... (1) \n \n -No, sono un vero uomo io!! \n[o donna, non discriminiamo nessuno qui] (2)");
        sceltaaiuti = scannervar.nextInt();

        return sceltaaiuti;
    }

    static int numerotentativi() {
        Scanner scannervar = new Scanner(System.in);
        int ennetentativi;
        System.out.println("Benissimo! Abbiamo la difficoltà e gli aiuti. Un'ultima cosa, quanti tentativi vuoi a tua disposizione?");
        System.out.print("-");
        ennetentativi = scannervar.nextInt();
        return ennetentativi;
    }

    static int giocoveroeproprio(int aiuti, int tentativi, int xmatrice, int ymatrice, int coord, int matrice[][]) {

        Scanner scannervar = new Scanner(System.in);
        int x_sparata = 0, y_sparata = 0, coordx = 0, coordy = 0;
        coordy = coord / 100;
        coordx = coord - (coordy * 100);
        System.out.print("Ok, per cominciare devi sapere che hai a disposizione " + xmatrice + " colonne");
        System.out.println(" e " + ymatrice + " righe. Non uscire dai bordi!");
        System.out.println("Cominciamo! ");
        while (matrice[x_sparata][y_sparata] != 1) 
        {
            while (x_sparata > 0 && x_sparata <= xmatrice) 
            {
                System.out.println("inserisci la x del punto che pensi sia corretto! ");
                x_sparata = scannervar.nextInt();
                if (x_sparata < 0 || x_sparata >= xmatrice) {
                    System.out.print("inserisci una x valida! ");
                }
            }
            while (y_sparata > 0 && y_sparata <= xmatrice) 
            {
                System.out.println("inserisci la y del punto che pensi sia corretto! ");
                y_sparata = scannervar.nextInt();
                if (y_sparata < 0 || y_sparata >= xmatrice) {
                    System.out.print("inserisci una y valida! ");
                }
            }
            if (aiuti == 1) 
            {
                System.out.print("Hai sbagliato, ma ecco un indizio: ");
                if(y_sparata==coordy)
                    System.out.print("hai beccato la y e ");
                if(y_sparata>coordy)
                    System.out.print("è più in basso e ");
                if(y_sparata<coordy)
                    System.out.print("è più in alto e ");
                if(x_sparata==coordy)
                    System.out.print("hai beccato la x.");
                if(x_sparata>coordx)
                    System.out.print("più a sinistra.");
                if(x_sparata<coordx)
                    System.out.print("più a destra.");
            }
        }

        return 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scannervar = new Scanner(System.in);
        Random randomvar = new Random();
        int difficoltascelta = 0, difficoltacoordinate = 0, sceltaaiuti = 0, tentativi = 0;
        int collocazione = 0;

        difficoltascelta = SceltaDifficolta();
        difficoltacoordinate = DifficoltàMatrice(difficoltascelta);

        int xmatrice = randomvar.nextInt(difficoltacoordinate), ymatrice = randomvar.nextInt(difficoltacoordinate);
        int matrice[][] = new int[xmatrice][ymatrice];

        collocazione = RiempimentoMatrice(matrice, xmatrice, ymatrice, difficoltacoordinate);
        sceltaaiuti = aiutiintegrati();
        tentativi = numerotentativi();
        System.out.println("Molto bene.. possiamo cominciare!");

        for (int i = 0; i < xmatrice; i++) {
            for (int j = 0; j < ymatrice; j++) {
                System.out.print(matrice[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

        giocoveroeproprio(sceltaaiuti, tentativi, xmatrice, ymatrice, collocazione, matrice);

    }

}
