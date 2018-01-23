package adam.atg.postupnost.valencna;

import java.util.ArrayList;
import java.util.Collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */

public class AlgoritmusVP {
    
    private ArrayList<Integer> postupnost;
    
    /**
     * Constructor for objects of class Test
     */
    public AlgoritmusVP(ArrayList<Integer> postupnost) {
        this.postupnost = postupnost;
    }
    
    public boolean vykonajAlg() {
        this.zorad();
        while (this.postupnost.size() > 0) {
            if (this.postupnost.get(0) > 0) {
                this.odcitaj1();
            } else if (this.postupnost.get(0) == 0 && this.getPosledny() == 0) {
                return true;
            } else if (this.getPosledny() < 0) {
                return false;
            }
        } 
        return true;
    }
    
    private void odcitaj1() {
        int hodnotaPrveho = this.postupnost.get(0);
        this.postupnost.remove(0);
        for (int pocitadlo = 0; pocitadlo < hodnotaPrveho; pocitadlo++) {
            this.postupnost.set(pocitadlo, this.postupnost.get(pocitadlo) - 1);
        }
        this.zorad();
            
    }
    
    public void zorad() {
        Collections.sort(this.postupnost, Collections.reverseOrder());
    }
    
    public int getPrvyClen() {
        this.zorad();
        return this.postupnost.get(0);
    }
    
    public int getSize() {
        return this.postupnost.size();
    }
    
    public int getPosledny() {
        return this.postupnost.get(this.getSize() - 1);
    }
}
