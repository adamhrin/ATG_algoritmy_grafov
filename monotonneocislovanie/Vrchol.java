package adam.atg.monotonneocislovanie;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Vrchol {
    private final char meno;
    private int cislo;
    private final ArrayList<Vrchol> zoznamPredchodcov;
    private boolean konecnaZnacka;

    public Vrchol(char meno) {
        this.meno = meno;
        this.zoznamPredchodcov = new ArrayList<>();
        this.konecnaZnacka = false;
    }

    public char getMeno() {
        return this.meno;
    }

    public int getCislo() {
        return this.cislo;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    void nastavPredchodcu(Vrchol vrchol) {
        this.zoznamPredchodcov.add(vrchol);
    }

    boolean maIdeg0() {
        return this.zoznamPredchodcov.isEmpty();
    }

    void vymazPredchodcu(Vrchol vrcholNaVymazaniePomocny) {
        Vrchol vrcholNaVymazanie = null;
        for (Vrchol vrchol : this.zoznamPredchodcov) {
            if (vrchol.equals(vrcholNaVymazaniePomocny)) {
                vrcholNaVymazanie = vrcholNaVymazaniePomocny;
            }
        }
        
        if (vrcholNaVymazanie != null) {
            this.zoznamPredchodcov.remove(vrcholNaVymazanie);
        }
    }

    boolean maKonecnuZnacku() {
        return this.konecnaZnacka;
    }

    void nastavKonecnuZnacku() {
        this.konecnaZnacka = true;
    }

}
