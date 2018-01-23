package adam.atg.postupnost.valencna;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */

public class ValencnaPostupnost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> postupnost = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        //System.out.println("Zadajte cisla postupnosti. Zadavanie konci zadanim znaku \"-1\"");
        //System.out.print(">");
        int clen = 0;
        postupnost.add(3);
        postupnost.add(2);
        postupnost.add(2);
        //postupnost.add(3);
        //postupnost.add(1);
        //postupnost.add(1);
        
        /*while (clen != -1) {
            clen = sc.nextInt();
            postupnost.add(clen);
            System.out.print(">");
        }*/
        
        AlgoritmusVP alg = new AlgoritmusVP(postupnost);
        alg.zorad();
        if (alg.getPrvyClen() < alg.getSize()) {
            if (alg.vykonajAlg()) {
                System.out.println("Tato VP prislucha nejakemu grafu");
            } else {
                System.out.println("Tato VP neprislucha nijakemu grafu");
            }
        } else {
            System.out.println("Zadali ste nepripustne udaje");
        }
        
    }
    
    
}
