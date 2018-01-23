/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.floydovalgoritmus;

/**
 *
 * @author Adam
 */
public class VykonavacAlgoritmu {
    private final Vrchol[] zoznamVrcholov;
    private final OrientovanaHrana[] zoznamHran;
    private int nekonecno;
    private int[][] maticaC;
    private char[][] maticaX;
    private int velkostMatice;
    

    public VykonavacAlgoritmu(Vrchol[] zoznamVrcholov, OrientovanaHrana[] zoznamHran) {
        this.zoznamVrcholov = zoznamVrcholov;
        this.zoznamHran = zoznamHran;
        this.velkostMatice = this.zoznamVrcholov.length;
        this.maticaC = new int[this.velkostMatice][this.velkostMatice];
        this.maticaX = new char[this.velkostMatice][this.velkostMatice];
        this.nekonecno = 1;
        
        for (OrientovanaHrana aktualnaHrana : this.zoznamHran) {
            this.nekonecno += aktualnaHrana.getCena();
        }
    }
    

    void vykonaj() {
        this.inicializujMaticuC();
        System.out.println("Povodna matica C");
        this.vypisMaticuC();
        this.inicializujMaticuX();
        System.out.println("Povodna matica X");
        this.vypisMaticuX();
        this.vykonajAlgoritmus();
        System.out.println("Vysledna matica C");
        this.vypisMaticuC();
        System.out.println("Vysledna matica X");
        this.vypisMaticuX();
        
    }

    private void inicializujMaticuC() {
        for (int i = 0; i < this.velkostMatice; i++) {
            for (int j = 0; j < this.velkostMatice; j++) {
                if (i == j) {
                    this.maticaC[i][j] = 0;
                } else if (this.existujeHrana(this.zoznamVrcholov[i], this.zoznamVrcholov[j])) {
                    int poradoveCisloHranyVZoznameHran = this.getPoradoveCisloHrany(this.zoznamVrcholov[i], this.zoznamVrcholov[j]);
                    this.maticaC[i][j] = this.zoznamHran[poradoveCisloHranyVZoznameHran].getCena();
                } else {
                    this.maticaC[i][j] = this.nekonecno;
                }
            }
        }
    }

    private void inicializujMaticuX() {
        for (int i = 0; i < this.velkostMatice; i++) {
            for (int j = 0; j < this.velkostMatice; j++) {
                if (i == j) {
                    this.maticaX[i][j] = this.zoznamVrcholov[i].getMeno();
                } else if (this.existujeHrana(this.zoznamVrcholov[i], this.zoznamVrcholov[j])) {
                    this.maticaX[i][j] = this.zoznamVrcholov[i].getMeno();
                } else {
                    this.maticaX[i][j] = '*';
                }
            }
        }
    }
    
    //zisti, ci sa orientovana hrana nachadza v zozname hran
    private boolean existujeHrana(Vrchol prvyVrchol, Vrchol druhyVrchol) {
        for (OrientovanaHrana hrana : this.zoznamHran) {
            if (hrana.getPrvyVrchol().getMeno() == prvyVrchol.getMeno() &&
                hrana.getDruhyVrchol().getMeno() == druhyVrchol.getMeno()) {
                return true;
            }
        }
        return false;
    }

    private int getPoradoveCisloHrany(Vrchol prvyVrchol, Vrchol druhyVrchol) {
        int poradoveCisloHrany = 0;
        for (OrientovanaHrana hrana : this.zoznamHran) {
            if (hrana.getPrvyVrchol().getMeno() == prvyVrchol.getMeno() &&
                hrana.getDruhyVrchol().getMeno() == druhyVrchol.getMeno()) {
                return poradoveCisloHrany;
            }
            poradoveCisloHrany++;
        }
        return poradoveCisloHrany;
    }

    private void vypisMaticuC() {
        for (int[] riadokMatice : this.maticaC) {
            for (int clenMatice : riadokMatice) {
                if (clenMatice == 32) {
                    System.out.print("* ");
                } else {
                    System.out.print(clenMatice + " ");
                }
            }
            System.out.println();
        }
    }

    private void vypisMaticuX() {
        for (char[] riadokMatice : this.maticaX) {
            for (char clenMatice : riadokMatice) {
                System.out.print(clenMatice + " ");
            }
            System.out.println();
        }
    }

    private void vykonajAlgoritmus() {
        for (int k = 0; k < this.zoznamVrcholov.length; k++) {
            for (int i = 0; i < this.zoznamVrcholov.length; i++) {
                for (int j = 0; j < this.zoznamVrcholov.length; j++) {
                    if (this.maticaC[i][j] > this.maticaC[i][k] + this.maticaC[k][j]) {
                        this.maticaC[i][j] = this.maticaC[i][k] + this.maticaC[k][j];
                        this.maticaX[i][j] = this.maticaX[k][j];
                    }
                }
            }
        }
    }
}