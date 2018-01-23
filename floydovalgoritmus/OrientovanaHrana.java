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
public class OrientovanaHrana {
    private final Vrchol prvyVrchol;
    private final Vrchol druhyVrchol;
    private final int cena;

    public OrientovanaHrana(Vrchol prvyVrchol, Vrchol druhyVrchol, int cena) {
        this.prvyVrchol = prvyVrchol;
        this.druhyVrchol = druhyVrchol;
        this.cena = cena;
    }

    public Vrchol getPrvyVrchol() {
        return this.prvyVrchol;
    }

    public Vrchol getDruhyVrchol() {
        return this.druhyVrchol;
    }

    public int getCena() {
        return this.cena;
    }
    
    
}
