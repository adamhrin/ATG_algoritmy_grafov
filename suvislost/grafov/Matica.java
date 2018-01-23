package adam.atg.suvislost.grafov;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Matica {

    private ArrayList<Integer> riadok;
    private final ArrayList<ArrayList<Integer>> matica;
    
    
    
    public Matica() {
        this.matica = new ArrayList<>();
        this.riadok = new ArrayList<>();
    }

    public void ponukniVstup() {
        Scanner citac = new Scanner(System.in);
        System.out.println("Zadaj cisla v matici, ");
        System.out.println("kazde v riadku oddel medzerou");
        System.out.println("a kazdy riadok Enter-om");
        System.out.println("Na konci zadavania riadkov matice napis \"koniec\"");
        while (true) {
            String riadokSMedzerami = citac.nextLine();
            //String riadokSMedzerami = "1 0 1";
            if (riadokSMedzerami.equals("koniec")) {
                System.out.println("Skoncilo zadavanie riadkov matice");
                return;
            }
            this.premenRiadokNaPoleCislic(riadokSMedzerami);
            this.matica.add(this.riadok);
            //System.out.println("Pokracuj v zadavani");
        }
    }
    
    private void premenRiadokNaPoleCislic(String riadokSMedzerami) {
        ArrayList<Integer> riadokCisel = new ArrayList<Integer>();
        int pokial = riadokSMedzerami.length();
        for (int pocitadlo = 0; pocitadlo < pokial; pocitadlo = pocitadlo + 2) {
            String znakCislica = "" + riadokSMedzerami.charAt(pocitadlo);
            int cislica = Integer.parseInt(znakCislica);
            riadokCisel.add(cislica);
            this.riadok = riadokCisel;
        }
        /*String riadokBezMedzier = riadokSMedzerami.replaceAll("\\s", "");
        int cislo = Integer.parseInt(riadokBezMedzier);
        //rozdeli cislo na cifry
        while (cislo > 0) {            
            riadokCisel.add(cislo % 10);
            cislo = cislo / 10;
        }
        Collections.reverse(riadokCisel);
        this.riadok = riadokCisel;*/
        
    }
    
    public void prezri() {
        int pocitadlo = 0;
        for (ArrayList<Integer>  riadok : this.matica) {
            for (Integer aktualnaHodnota : riadok) {
                System.out.print(aktualnaHodnota.intValue() + " ");
                if (aktualnaHodnota.intValue() == 1) {
                    pocitadlo++;
                }
            }
            System.out.println();
        }
        
        //vypise, ze graf je suvisly, ak su vsetky cisla v matici jednotky, inak vypise ze graf je nesuvisly
        if (pocitadlo == (this.getStupen() * this.getStupen())) {
            System.out.println("Graf reprezentovany touto maticou je suvisly");
        } else {
            System.out.println("Graf reprezentovany touto maticou NIE je suvisly");
        }
    }
    /**
     * Metoda vracia prvok matice v riadku a stlpci, ktore su zadane v parametri
     * @param riadok
     * @param stlpec
     * @return 
     */
    public int getPrvok(int riadok, int stlpec) {
        return this.matica.get(riadok).get(stlpec);
    }
    
    public int getStupen() {
        if (this.matica.size() == this.matica.get(0).size()) {
            return this.matica.size();
        }
        //ak nema rovnaky pocet riadkov a stlpcov
        return -1;
    }

    public void vlozPrvok(int riadok, int stlpec, int novyPrvok) {
        this.matica.get(riadok).set(stlpec, novyPrvok);
        /*this.matica.get(riadok).remove(stlpec);
        this.matica.get(riadok).add(stlpec, novyPrvok);*/
    }
    
    
    public Matica logickyScitajS(Matica druhaMatica) {
        
        Matica vyslednaMatica = new Matica();
        int stupen = this.getStupen();
        vyslednaMatica.naplnNulami(stupen);
        for (int i = 0; i < stupen; i++) {
            for (int j = 0; j < stupen; j++) {
                int novyPrvok = this.getPrvok(i, j) + druhaMatica.getPrvok(i, j);
                if (novyPrvok > 0) {
                    vyslednaMatica.vlozPrvok(i, j, 1);
                } else {
                    vyslednaMatica.vlozPrvok(i, j, 0);
                }
            }
        }
        //System.out.println("Tvoja nova matica");
        //vyslednaMatica.prezri();
        return vyslednaMatica;
    }
    
    private void naplnNulami(int stupenMatice) {
        
        for (int i = 0; i < stupenMatice; i++) {
            ArrayList<Integer> dalsiRiadok = new ArrayList<>();
            for (int j = 0; j < stupenMatice; j++) {
                dalsiRiadok.add(0);
            }
            this.matica.add(dalsiRiadok);
        }
    }
    
    public Matica logickyVynasobS(Matica druhaMatica) {
        Matica vyslednaMatica = new Matica();
        int stupen = this.getStupen();
        vyslednaMatica.naplnNulami(stupen);
        for (int i = 0; i < stupen; i++) {
            for (int j = 0; j < stupen; j++) {
                int novyPrvok = 0;
                for (int k = 0; k < stupen; k++) {
                    novyPrvok += this.getPrvok(i, k) * druhaMatica.getPrvok(k, j);
                }
                if (novyPrvok > 0) {
                    vyslednaMatica.vlozPrvok(i, j, novyPrvok);
                } else {
                    vyslednaMatica.vlozPrvok(i, j, 0);
                }
            }
        }
        //System.out.println("Tvoja nova matica");
        //vyslednaMatica.prezri();
        return vyslednaMatica;
    }
}
