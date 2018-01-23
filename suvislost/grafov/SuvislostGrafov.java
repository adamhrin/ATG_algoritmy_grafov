package adam.atg.suvislost.grafov;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class SuvislostGrafov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matica maticaA = new Matica();
        maticaA.ponukniVstup();
        Matica vysledna = new Matica();
        Matica pomocnaPreNasobenie = new Matica();
        
        //prva pseudo-iteracia nasledujuceho for-cyklu
        pomocnaPreNasobenie = maticaA.logickyVynasobS(maticaA);
        vysledna = maticaA.logickyScitajS(pomocnaPreNasobenie);
        
        for (int pocitadlo = 2; pocitadlo <= maticaA.getStupen() - 1; pocitadlo++) {
            pomocnaPreNasobenie = maticaA.logickyVynasobS(pomocnaPreNasobenie);
            vysledna = vysledna.logickyScitajS(pomocnaPreNasobenie);
        }
        System.out.println("Vysledna matica");
        vysledna.prezri();
    }
    
}
