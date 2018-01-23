/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.depthfirstsearch;

/**
 *
 * @author Adam
 */
public class OrientovanaHrana {
    private final Vrchol prvyVrchol;
    private final Vrchol druhyVrchol;

    public OrientovanaHrana(Vrchol prvyVrchol, Vrchol druhyVrchol) {
        this.prvyVrchol = prvyVrchol;
        this.druhyVrchol = druhyVrchol;
    }

    public Vrchol getPrvyVrchol() {
        return this.prvyVrchol;
    }

    public Vrchol getDruhyVrchol() {
        return this.druhyVrchol;
    }

}
