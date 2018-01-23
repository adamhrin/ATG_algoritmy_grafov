package adam.atg.depthfirstsearch;

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
    private final ArrayList<Vrchol> zoznamSusednychVrcholov;
    private boolean konecnaZnacka;
    private boolean jeNavstiveny;

    public Vrchol(char meno) {
        this.meno = meno;
        this.zoznamSusednychVrcholov = new ArrayList<>();
        this.konecnaZnacka = false;
        this.jeNavstiveny = false;
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

    void nastavSuseda(Vrchol vrchol) {
        this.zoznamSusednychVrcholov.add(vrchol);
    }

//    void vymazPredchodcu(Vrchol vrcholNaVymazaniePomocny) {
//        Vrchol vrcholNaVymazanie = null;
//        for (Vrchol vrchol : this.zoznamSusednychVrcholov) {
//            if (vrchol.equals(vrcholNaVymazaniePomocny)) {
//                vrcholNaVymazanie = vrcholNaVymazaniePomocny;
//            }
//        }
//        
//        if (vrcholNaVymazanie != null) {
//            this.zoznamSusednychVrcholov.remove(vrcholNaVymazanie);
//        }
//    }

    Vrchol getSused(int poradoveCislo) {
        return this.zoznamSusednychVrcholov.get(poradoveCislo);
    }
    
    void oznacNavstiveny() {
        this.jeNavstiveny = true;
    }

    boolean jeNavstiveny() {
        return this.jeNavstiveny;
    }

    int getVelkostZoznamuSusedov() {
        return this.zoznamSusednychVrcholov.size();
    }

    ArrayList<Vrchol> getZoznamSusedov() {
        return this.zoznamSusednychVrcholov;
    }
}
