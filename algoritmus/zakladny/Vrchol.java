package adam.atg.algoritmus.zakladny;

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
    private int t;//dlzka doteraz najkratsej cesty
    private Vrchol x;//predposledny vrchol doteraz najkratsej cesty
    private final char meno;

    public Vrchol(char meno) {
        this.meno = meno;
        this.x = null;
        this.t = 0;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void setX(Vrchol x) {
        this.x = x;
    }

    public int getT() {
        return this.t;
    }

    public Vrchol getX() {
        return this.x;
    }

    public char getMeno() {
        return this.meno;
    }
    
    
    
    
}
