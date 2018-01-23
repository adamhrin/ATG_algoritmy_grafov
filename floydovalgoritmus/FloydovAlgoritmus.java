package adam.atg.floydovalgoritmus;

import java.util.ArrayList;
import java.util.Collections;
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
public class FloydovAlgoritmus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner citacVrcholov = new Scanner(System.in);
        ArrayList<Vrchol> vrcholyPomoc = new ArrayList<>();
        
        boolean koniecZadavaniaVrcholov = false;
        System.out.println("Zadaj postupne nazvy vrcholov (oddelene enterom)\n"
                            + "na konci napis \"koniec\":");
        
        while (!koniecZadavaniaVrcholov) {            
            String menoVrchola = citacVrcholov.next();
            if (!menoVrchola.equals("koniec")) {
                vrcholyPomoc.add(new Vrchol(menoVrchola.charAt(0)));
            } else {
                koniecZadavaniaVrcholov = true;
                System.out.println("Koniec zadavania vrcholov");
            }
        }
        
          
        Vrchol[] zoznamVrcholov = new Vrchol[vrcholyPomoc.size()];
        for (int i = 0; i < zoznamVrcholov.length; i++) {
            zoznamVrcholov[i] = vrcholyPomoc.get(i);
            //System.out.println(zoznamVrcholov[i].getMeno());
        }
        
        
        Scanner citacHran = new Scanner(System.in);
        ArrayList<OrientovanaHrana> hranyPomoc = new ArrayList<>();
        System.out.println("Zadaj \"hrana_medzera_cena\" (napr. ab 3), na konci napis \"koniec\":");
        boolean koniecZadavaniaHran = false;
        
        Vrchol prvyVrchol = null;
        Vrchol druhyVrchol = null;
        while (!koniecZadavaniaHran) {
            String hranaString = citacHran.next();
            if (!hranaString.equals("koniec")) {
                
                for (Vrchol vrchol : vrcholyPomoc) {
                    if (vrchol.getMeno() == hranaString.charAt(0)) {
                        prvyVrchol = vrchol;
                    }
                }
                for (Vrchol vrchol : vrcholyPomoc) {
                    if (vrchol.getMeno() == hranaString.charAt(1)) {
                        druhyVrchol = vrchol;
                    }
                }
                
                hranyPomoc.add(new OrientovanaHrana(prvyVrchol, druhyVrchol, citacHran.nextInt()));
            } else {
                koniecZadavaniaHran = true;
                System.out.println("Koniec zadavania hran");
            }
        }
        
        OrientovanaHrana[] zoznamHran = new OrientovanaHrana[hranyPomoc.size()];
        for (int i = 0; i < zoznamHran.length; i++) {
            zoznamHran[i] = hranyPomoc.get(i);
        }
        
        VykonavacAlgoritmu alg = new VykonavacAlgoritmu(zoznamVrcholov, zoznamHran);
        alg.vykonaj();
    }
    
}
