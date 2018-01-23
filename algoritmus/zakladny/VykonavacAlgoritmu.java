/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.algoritmus.zakladny;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class VykonavacAlgoritmu {
    private final Vrchol[] zoznamVrcholov;
    private final OrientovanaHrana[] zoznamHran;
    private int nekonecno;
    private ArrayList<Vrchol> rekurzivnaCestaZPrveho;

    public VykonavacAlgoritmu(Vrchol[] zoznamVrcholov, OrientovanaHrana[] zoznamHran) {
        this.rekurzivnaCestaZPrveho = new ArrayList<>();
        this.zoznamVrcholov = zoznamVrcholov;
        this.zoznamHran = zoznamHran;
        this.nekonecno = 1;
        
        for (OrientovanaHrana aktualnaHrana : this.zoznamHran) {
            this.nekonecno += aktualnaHrana.getCena();
        }
    }
    
    public void vykonaj() {
        
        for (int i = 2; i < this.zoznamVrcholov.length; i++) {
            this.zoznamVrcholov[i].setT(this.nekonecno);
        }
        
        boolean jeKoniec = false;
        
        while (!jeKoniec) {
            int pocetZmienVZozname = 0;
            for (OrientovanaHrana aktualnaHrana : this.zoznamHran) {
                Vrchol prvyVrchol = aktualnaHrana.getPrvyVrchol();
                Vrchol druhyVrchol = aktualnaHrana.getDruhyVrchol();
                
                if (prvyVrchol.getT() + aktualnaHrana.getCena() < druhyVrchol.getT()) {
                    aktualnaHrana.getDruhyVrchol().setT(prvyVrchol.getT() + aktualnaHrana.getCena());
                    aktualnaHrana.getDruhyVrchol().setX(prvyVrchol);
                    pocetZmienVZozname++;
                }
            }
            if (pocetZmienVZozname == 0) {
                jeKoniec = true;
            }
        }
        
        System.out.println("Najkratsie cesty z vrchola " + this.zoznamVrcholov[1].getMeno() + " do vsetkych vrcholov");
        System.out.println(this.zoznamVrcholov[1].getMeno() + ": najkratsia cesta: 0, predposleny vrchol: neexistuje");
        for (int i = 2; i < this.zoznamVrcholov.length; i++) {
            System.out.print(this.zoznamVrcholov[i].getMeno() + ": ");

            if (this.zoznamVrcholov[i].getX() != null) {
                System.out.print("najkratsia cesta: " + this.zoznamVrcholov[i].getT() + ", ");
                System.out.print("predposledny vrchol: " + this.zoznamVrcholov[i].getX().getMeno());
            } else {
                System.out.print("neexistuje cesta z vrchola \'" + this.zoznamVrcholov[1].getMeno() + "\' do tohto vrchola");
            }
            System.out.println();
        }
        
    }
    
    
    public void rekurzivnePriradPredposlednyVrchol(Vrchol odkial) {
        if (odkial.getX() != null) {
            Vrchol predposlednyVrchol = odkial.getX();
            this.rekurzivnaCestaZPrveho.add(predposlednyVrchol);
            this.rekurzivnePriradPredposlednyVrchol(predposlednyVrchol);
        } else {
            return;
        }
        
    }
    
    /**
     * Skonstruuje cesty z prveho vrchola do vrchola zadaneho parametrom
     */
    public void skonstruujCestu(Vrchol odkial, Vrchol kam) {
        System.out.println("Najkratsia cesta z vrchola \'" + 
                            this.zoznamVrcholov[1].getMeno() +
                            "\' do vrchola \'" +  
                            kam.getMeno() + 
                            "\':");
        for (int i = this.rekurzivnaCestaZPrveho.size() - 1; i >= 0; i--) {
            System.out.print(this.rekurzivnaCestaZPrveho.get(i).getMeno() + "-");
        }
        System.out.print(kam.getMeno());
        System.out.println();
        this.rekurzivnaCestaZPrveho = new ArrayList<>();
    }
}
