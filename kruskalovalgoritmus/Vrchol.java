package adam.atg.kruskalovalgoritmus;

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

    public Vrchol(char meno) {
        this.meno = meno;
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

}
